package com.mdp.test.domain.usecase

import com.mdp.test.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val repo: UserRepository) {
    suspend operator fun invoke() = repo.getUsers()
}