package com.devapps.mwyouthfootballportal.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.devapps.mwyouthfootballportal.R
import com.devapps.mwyouthfootballportal.views.homeFragments.AgentFragment
import com.devapps.mwyouthfootballportal.views.homeFragments.HomeFragment
import com.devapps.mwyouthfootballportal.views.homeFragments.TeamFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instantiating Fragments
        val firstFragment = HomeFragment()
        val secondFragment = AgentFragment()
        val thirdFragment = TeamFragment()

        //Instantiating of bottom navigation
        val bottomNavigationView : BottomNavigationView = findViewById(R.id.bottom_nav)

        //Default screen
        setCurrentFragment(firstFragment)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home -> setCurrentFragment(firstFragment)
                R.id.agent -> setCurrentFragment(secondFragment)
                R.id.team -> setCurrentFragment(thirdFragment)
            }; true
        }


    }

    //Function to display current fragment
    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fLayout, fragment)
            commit()
        }
    }

}