package com.skills.example.usingviewmodel

import android.content.pm.ActivityInfo
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @JvmField
    @Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkViewsIsDisplayed() {
        onView(withId(R.id.tv_counter)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_increase)).check(matches(isDisplayed()))
    }

    @Test
    fun onButtonClick_increaseCounter() {
        var count = 0
        onView(withId(R.id.btn_increase)).perform(click())
        count++
        onView(withId(R.id.tv_counter)).check(matches(withText("$count")))
    }

    @Test
    fun checkOnConfigurationChangedValueBecomeZero() {
        onView(withId(R.id.btn_increase)).perform(click())
        onView(withId(R.id.btn_increase)).perform(click())
        onView(withId(R.id.btn_increase)).perform(click())

        onView(withId(R.id.tv_counter)).check(matches(withText("3")))

        activityRule.scenario.onActivity {
            it.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        onView(withId(R.id.tv_counter)).check(matches(withText("0")))

    }


    @Test
    fun checkOnConfigurationChangedValueStayTheSame() {
        onView(withId(R.id.btn_increase)).perform(click())
        onView(withId(R.id.btn_increase)).perform(click())
        onView(withId(R.id.btn_increase)).perform(click())

        onView(withId(R.id.tv_counter)).check(matches(withText("3")))

        activityRule.scenario.onActivity {
            it.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        onView(withId(R.id.tv_counter)).check(matches(withText("3")))

    }

}