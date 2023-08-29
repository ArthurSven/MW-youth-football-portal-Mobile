package com.devapps.mwyouthfootballportal.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devapps.mwyouthfootballportal.data.model.Agent
import com.devapps.mwyouthfootballportal.repository.AgentRepository
import com.devapps.mwyouthfootballportal.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject


class UserViewModel(
    private val agentRepository: AgentRepository
) : ViewModel() {

    private val _insertAgentResult = MutableLiveData<Resource<Void>>()
    val insertAgentResult: LiveData<Resource<Void>> = _insertAgentResult

    suspend fun insertAgent(agent: Agent) {
        viewModelScope.launch {
            val response: Response<Void> = agentRepository.insertAgentData(agent)
            try {
                if (response.isSuccessful) {
                    _insertAgentResult.postValue(
                        Resource.Success<Void>
                            (null, "Agent account successfully created"))
                    } else {
                    _insertAgentResult.postValue(Resource.Error<Void>
                        ("An error occurred.", null)) // Error
                }
                }
                catch (e: IOException) {
                    _insertAgentResult.postValue(Resource.Error<Void>
                        ("Network error.", null)) // Network-related error
        } catch (e: Exception) {
                _insertAgentResult.postValue(Resource.Error<Void>
                    ("An unexpected error occurred.", null)) // Other exceptions
        }
        }
    }
}