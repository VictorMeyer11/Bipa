package com.clansoft.main.data.repository

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.clansoft.main.data.datasource.MainDataSource
import com.clansoft.main.data.mapper.NodeMapper
import com.clansoft.main.domain.model.Node
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

class MainRepositoryImplTest {
    private val dataSource: MainDataSource = mockk()
    private val nodeMapper: NodeMapper = mockk()
    private val repository = MainRepositoryImpl(
        dataSource = dataSource,
        nodeMapper = nodeMapper
    )

    @Test
    fun `valid response with result`() = runTest {
        val element1 = mockk<Node>()
        val expected: List<Node> = listOf(element1)

        coEvery {
            dataSource.getNodeList()
        } returns Result.success(listOf(mockk()))

        every {
            nodeMapper.map(any())
        } returns element1

        val result = repository.getNodes()

        assertThat(result.getOrNull()).isEqualTo(expected)
    }

    @Test
    fun `invalid response with failure`() = runTest {
        val expected: Throwable = mockk()

        coEvery {
            dataSource.getNodeList()
        } returns Result.failure(expected)

        val result = repository.getNodes()

        assertThat(result.exceptionOrNull()).isEqualTo(expected)
    }

    @Test
    fun `when repository is invoked, data source is called`() = runTest {
        coEvery {
            dataSource.getNodeList()
        } returns Result.failure(mockk())

        repository.getNodes()
        coVerify {
            dataSource.getNodeList()
        }
    }
}
