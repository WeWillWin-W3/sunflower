/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.sunflower

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class GardenActivityTest {

    @Rule @JvmField
    var activityTestRule = ActivityScenarioRule(GardenActivity::class.java)

    @Test fun clickAddPlant_OpensPlantList() {
        // Given that no Plants are added to the user's garden

        // When the "Add Plant" button is clicked
        onView(withId(R.id.add_plant)).perform(click())

        // Then the ViewPager should change to the Plant List page
        onView(withId(R.id.plant_list)).check(matches(isDisplayed()))
    }

    @Test fun clickPlantListTab_OpensPlantList() {
        // Given that no Plants are added to the user's garden

        // When the plant list tab is clicked
        onView(withText(R.string.plant_list_title)).perform(click())

        // Then the ViewPager should change to the Plant List page
        onView(withId(R.id.plant_list)).check(matches(isDisplayed()))
    }

    @Test fun clickPlantListFilter_OpensPlantList() {
        // Given that no Plants are added to the user's garden

        // When the "Add Plant" button is clicked
        onView(withText(R.string.plant_list_title)).perform(click())

        // When the "Add Plant" button is clicked
        onView(withId(R.id.filter_zone)).perform(click())

        // Then the ViewPager should change to the Plant List page with this plants
        onView(withText("Avocado")).check(matches(isDisplayed()))
        onView(withText("Grape")).check(matches(isDisplayed()))
        onView(withText("Orange")).check(matches(isDisplayed()))
        onView(withText("Tomato")).check(matches(isDisplayed()))
    }
}
