package com.example.swipegestures

import android.os.SystemClock
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import java.net.URL

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val mainActivityRule = ActivityScenarioRule(ShowListActivity::class.java)

    @Test
    fun recycleViewTest() {

        val item = onView(withId(R.id.rv_showList))

        //scrollTo
//        item.perform(RecyclerViewActions.scrollTo<ListAdapter.ListViewHolder>(hasDescendant(withText("j"))))
        //scroll To Position
 //       item.perform(RecyclerViewActions.scrollToPosition<ListAdapter.ListViewHolder>(10))

        //action on item at position
//        item.perform(RecyclerViewActions.actionOnItemAtPosition<ListAdapter.ListViewHolder>(23, click()))

        //action on item
        item.perform(RecyclerViewActions.actionOnItem<ListAdapter.ListViewHolder>(
            hasDescendant(withText("p")),
            clickChildViewWithId(R.id.iv_star)))

        //scroll to holder and action on holder not working yet


//        item.perform(click())


    }

    fun clickChildViewWithId(id: Int): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View>? {
                return null
            }

            override fun getDescription(): String {
                return "Click on a child view with specific id."
            }

            override fun perform(
                uiController: UiController,
                view: View
            ) {
                val v = view.findViewById<View>(id)
                v.performClick()
            }
        }
    }
}

