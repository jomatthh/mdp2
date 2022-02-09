package com.mdp.test.data.repository

import com.mdp.test.data.remote.user.UserRemoteDataSource
import com.mdp.test.data.remote.user.toUser
import com.mdp.test.domain.model.User
import com.mdp.test.domain.repository.UserRepository
import com.mdp.test.vo.OperationResult
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataSource: UserRemoteDataSource
) : UserRepository {
    override suspend fun getUsers(): OperationResult<List<User>> {
        return when (val result = dataSource.getUsers()) {
            is OperationResult.Success -> {
                val data = result.data.map { it.toUser() }
                OperationResult.Success(data)
            }
            is OperationResult.Failure -> {
                OperationResult.Failure(result.exception)
            }
        }
    }
}