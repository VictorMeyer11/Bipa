package com.clansoft.main.domain.usecase

import com.clansoft.main.domain.model.Node
import com.clansoft.main.domain.repository.MainRepository
import javax.inject.Inject

class GetNodes @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke(): Result<List<Node>> = run {
        try {
            mainRepository.getNodes()
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
