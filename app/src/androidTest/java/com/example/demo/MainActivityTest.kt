package com.example.demo

import org.junit.Test
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.demo.view.MainActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun test_isMainActivityVisible_onAppLaunch() {
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun testDocBtnClick() {
        onView(withId(R.id.DocBtn)).perform(click())
        onView(withId(R.id.doctor)).check(matches(isDisplayed()))

    }

    @Test
    fun testPatientBtnClick() {
        onView(withId(R.id.PatientBtn)).perform(click())
        onView(withId(R.id.booking)).check(matches(isDisplayed()))
    }

}