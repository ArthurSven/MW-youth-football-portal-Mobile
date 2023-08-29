package com.devapps.mwyouthfootballportal.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devapps.mwyouthfootballportal.repository.AgentRepository

class UserViewModelFactory(private val agentRepository: AgentRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(agentRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}