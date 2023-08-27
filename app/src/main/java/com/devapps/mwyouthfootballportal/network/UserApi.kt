package com.devapps.mwyouthfootballportal.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("/insert-agent")
    suspend fun insertAgentData(
        @Body agent: String,
        lastname: String,
        email: String,
        username: String,
        password: String,
        currentDate: Long,
        agentUser: String
    ): Response<Void>
}