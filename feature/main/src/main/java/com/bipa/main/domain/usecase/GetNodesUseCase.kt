package com.bipa.main.domain.usecase

import com.bipa.main.domain.model.Node
import com.bipa.main.domain.repository.MainRepository
import javax.inject.Inject

class GetNodesUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke(): Result<List<Node>> = mainRepository.getNodes()
}
