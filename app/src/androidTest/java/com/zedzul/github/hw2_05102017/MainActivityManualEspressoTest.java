package com.zedzul.github.hw2_05102017;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityManualEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void onCreate() throws Exception {
        final ViewInteraction pInputEditText = onView(withId(R.id.input_edit_text));
        final ViewInteraction pSolveButton = onView(withId(R.id.solve_button));
        final ViewInteraction pResultTextView = onView(withId(R.id.result_text_view));

        //TODO Espresso. Test passed
        pInputEditText.perform(typeText("77+41"));
        pSolveButton.perform(click());
        pResultTextView.check(matches(withText("118")));

        //TODO Espresso. Test failed
        //pResultTextView.check(matches(withText("117")));

    }

}