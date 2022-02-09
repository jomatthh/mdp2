package com.mdp.test.data.remote.user

import com.mdp.test.Constants
import com.mdp.test.data.remote.api.WebService
import com.mdp.test.vo.OperationResult
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val webService: WebService
) {
    suspend fun getUsers(): OperationResult<List<UserRemote>> {
        return try {
            val response = webService.getUsers()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    OperationResult.Success(body)
                } else {
                    OperationResult.Failure(Exception(Constants.UN_EXPECTED_ERROR))
                }
            } else {
                OperationResult.Failure(Exception(response.errorBody()?.toString()))
            }
        } catch (e: Exception) {
            OperationResult.Failure(e)
        }
    }
}