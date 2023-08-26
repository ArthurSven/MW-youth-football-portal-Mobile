package com.devapps.mwyouthfootballportal.views.homeFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.devapps.mwyouthfootballportal.R
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var greetingTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize your TextView

        greetingTextView = rootView.findViewById(R.id.greeting)

        // Get the current time
        val calendar = Calendar.getInstance()

        // Update the greeting based on the time
        val greeting = when (calendar.get(Calendar.HOUR_OF_DAY)) {
            in 3 until 12 -> "Good Morning"
            in 12 until 17 -> "Good Afternoon"
            else -> "Good Evening"
        }
        greetingTextView.text = greeting
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}