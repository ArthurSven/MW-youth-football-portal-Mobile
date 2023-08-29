package com.devapps.mwyouthfootballportal.network

import com.devapps.mwyouthfootballportal.data.model.Agent
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("/insert-agent")
    suspend fun insertAgentData(@Body agent: Agent): Response<Void>
}