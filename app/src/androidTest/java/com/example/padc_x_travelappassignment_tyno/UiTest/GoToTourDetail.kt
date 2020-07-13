package com.example.padc_x_travelappassignment_tyno.UiTest

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.padc_x_travelappassignment_tyno.R
import com.example.padc_x_travelappassignment_tyno.activities.MainActivity
import com.example.padc_x_travelappassignment_tyno.viewHolders.TourViewholder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class GoToTourDetail {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapOnTour_navigateToTourDetails() {
        onView(withId(R.id.rvPopularTours))
            .perform(RecyclerViewActions.actionOnItemAtPosition<TourViewholder>(0,click()))
        onView(withId(R.id.tvDetailText))
            .check(matches(isDisplayed()))
    }
}