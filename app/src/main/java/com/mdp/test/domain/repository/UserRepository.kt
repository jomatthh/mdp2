package com.mdp.test.domain.repository

import com.mdp.test.domain.model.User
import com.mdp.test.vo.OperationResult

interface UserRepository {
    suspend fun getUsers(): OperationResult<List<User>>
}