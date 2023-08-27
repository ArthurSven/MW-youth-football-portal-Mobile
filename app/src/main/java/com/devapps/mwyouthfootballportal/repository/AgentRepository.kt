package com.devapps.mwyouthfootballportal.repository

import com.devapps.mwyouthfootballportal.network.RetrofitInstance
import com.devapps.mwyouthfootballportal.network.UserApi
import retrofit2.Response
import javax.inject.Inject


class AgentRepository @Inject constructor(
    private var userApi: UserApi
) {
    init {
        userApi = RetrofitInstance().getRetrofitInstance()
            .create(UserApi::class.java)
    }

    suspend fun insertAgentData(
        firstname: String,
        lastname: String,
        email: String,
        username: String,
        password: String
    ): Response<Void> {
        val dateJoined = System.currentTimeMillis()
        val agentUser = "agent"

        return userApi.insertAgentData(
            firstname,
            lastname,
            email,
            username,
            password,
            dateJoined,
            agentUser
        )
    }
}