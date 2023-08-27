package com.devapps.mwyouthfootballportal.data.model

import androidx.room.Entity
import java.io.Serializable
@Entity
data class Agent(
    val firstname: String,
    val lastname: String,
    val email: String,
    val username: String,
    val password: String,
    val date_joined: String,
    val userType: String
    )
