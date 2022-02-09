package com.mdp.test.data.remote.api

import com.mdp.test.data.remote.user.UserRemote
import retrofit2.Response
import retrofit2.http.GET

interface WebService {
    @GET("/users")
    suspend fun getUsers(): Response<List<UserRemote>>
}