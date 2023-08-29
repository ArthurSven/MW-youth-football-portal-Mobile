package com.devapps.mwyouthfootballportal.repository

import com.devapps.mwyouthfootballportal.data.model.Agent
import com.devapps.mwyouthfootballportal.network.RetrofitInstance
import com.devapps.mwyouthfootballportal.network.UserApi
import retrofit2.Response
import javax.inject.Inject


class AgentRepository() {

    private var userApi: UserApi = RetrofitInstance().getRetrofitInstance()
        .create(UserApi::class.java)

    suspend fun insertAgentData(agent: Agent): Response<Void> {
        return userApi.insertAgentData(agent)
    }
}