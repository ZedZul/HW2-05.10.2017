package com.zedzul.github.hw2_05102017;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)

public class MainActivityRobolectricTest {

    private MainActivity mActivity;
    private ActivityController<MainActivity> activityController;

    @Before
    public void setup() {
        mActivity = Robolectric.buildActivity(MainActivity.class).create().start().resume().get();

    }

    @Test
    public void onCreate() throws Exception {

        // mActivity = Robolectric.setupActivity(MainActivity.class);

        final View pSolveButton = mActivity.findViewById(R.id.solve_button);
        final EditText pInputEditText = (EditText) mActivity.findViewById(R.id.input_edit_text);
        final TextView pResultTextView = (TextView) mActivity.findViewById(R.id.result_text_view);

        //TODO: Robolectric. Test passed
        pInputEditText.setText("77+41");
        pSolveButton.performClick();
        assertEquals(pResultTextView.getText().toString(), "118");

        //TODO: Robolectric. Test failed
        //assertEquals(pResultTextView.getText().toString(), "117");
    }

}