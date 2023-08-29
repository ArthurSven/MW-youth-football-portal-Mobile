package com.devapps.mwyouthfootballportal.views.homeFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.devapps.mwyouthfootballportal.R
import com.devapps.mwyouthfootballportal.data.model.Agent
import com.devapps.mwyouthfootballportal.databinding.FragmentAgentBinding
import com.devapps.mwyouthfootballportal.network.UserApi
import com.devapps.mwyouthfootballportal.repository.AgentRepository
import com.devapps.mwyouthfootballportal.utils.Resource
import com.devapps.mwyouthfootballportal.viewmodels.UserViewModel
import com.devapps.mwyouthfootballportal.viewmodels.UserViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class AgentFragment() : Fragment() {

    lateinit var userViewModel: UserViewModel
    lateinit var binding: FragmentAgentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAgentBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val agentRepository = AgentRepository()
        /// Initialize your UserViewModel
        userViewModel = UserViewModel(agentRepository)

        binding.agentRegistration.setOnClickListener {
            val firstname = binding.agentRegFirstname.text.toString()
            val lastname = binding.agentRegLastname.text.toString()
            val email = binding.agentRegEmail.text.toString()
            val username = binding.agentRegUsername.text.toString()
            val password = binding.agentRegPassword.text.toString()
            val dateJoined = getCurrentDateAsString()
            val userType = "Agent"

            val agent = Agent(firstname, lastname, email, username, password, dateJoined, userType)

            CoroutineScope(Dispatchers.Main).launch {
                try{
                    val result = userViewModel.insertAgent(agent)
                    if (result != null) {
                        Toast.makeText(requireContext(),
                            "Agent account: $username successfully created", Toast.LENGTH_LONG)
                            .show()
                    }

                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(requireContext(), e.message, Toast.LENGTH_LONG).show()
                    }
                }
            }

        }
    }


    private fun getCurrentDateAsString(): String {
        val currentDate = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return dateFormat.format(currentDate)
    }

}