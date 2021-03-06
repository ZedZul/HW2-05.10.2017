package com.zedzul.github.hw2_05102017;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class RecordEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void espressoTest() {
        final ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.solve_button), withText("Solve it"), isDisplayed()));
        appCompatButton.perform(click());

        final ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.input_edit_text), isDisplayed()));
        appCompatEditText.perform(click());

        final ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.input_edit_text), isDisplayed()));
        appCompatEditText2.perform(replaceText("523"), closeSoftKeyboard());

    }

}
