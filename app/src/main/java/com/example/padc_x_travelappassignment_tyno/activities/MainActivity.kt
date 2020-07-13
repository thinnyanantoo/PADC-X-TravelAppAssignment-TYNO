package com.example.padc_x_travelappassignment_tyno.activities

import android.os.Bundle
import android.view.MenuItem
import com.example.padc_x_travelappassignment_tyno.R
import com.example.padc_x_travelappassignment_tyno.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private fun replaceFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.fLBottomNavigationContainer,
            HomeFragment.newInstance("","")).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.bottomNavigation_home_menu -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fLBottomNavigationContainer,
                        HomeFragment.newInstance("A","B")
                    )
                        .commit()
                    return true
                    }
                    R.id.bottomNavigation_star_menu -> {
                            supportFragmentManager.beginTransaction().replace(
                                R.id.fLBottomNavigationContainer,
                                StarFragment.newInstance("A","B")
                            )
                                .commit()
                            return true
                    }
                    R.id.bottomNavigation_favorite_menu -> {
                        supportFragmentManager.beginTransaction().replace(
                            R.id.fLBottomNavigationContainer,
                            favouriteFragment.newInstance("A","B")
                        )
                            .commit()
                        return true
                    }
                    R.id.bottomNavigation_monetization_menu -> {
                        supportFragmentManager.beginTransaction().replace(
                            R.id.fLBottomNavigationContainer,
                            DollarFragment.newInstance("A","B")
                        )
                            .commit()
                        return true
                    }
                    R.id.bottomNavigation_search_menu-> {
                        supportFragmentManager.beginTransaction().replace(
                            R.id.fLBottomNavigationContainer,
                            SearchFragment.newInstance("A","B")
                        )
                            .commit()
                        return true
                    }

                    }
                return false

            }
        })
    }
}