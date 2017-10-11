package com.zedzul.github.hw2_05102017;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityMockitoRobolectricTest {

    private MainActivity mActivity;

    private ICalculator mMockICalculator;
    private Calculator mSpyCalculator;

    @Before
    public void setup() {
        mActivity = Robolectric.setupActivity(MainActivity.class);
        mMockICalculator = mock(ICalculator.class);
        mSpyCalculator = spy(Calculator.class);
    }

    @Test
    public void use_mock() throws Exception {

        when(mMockICalculator.solve("any")).thenReturn("255");
        //passed mock test
        assertEquals(mMockICalculator.solve("any"), "255");

        //failed mock tests
        //assertEquals(mMockICalculator.solve("anyany"), "255"); //null and 255
        //assertEquals(mMockICalculator.solve("any"), "0"); // 255 and 0

        assertEquals(mActivity.findViewById(R.id.solve_button).isEnabled(), false);

    }

    @Test
    public void use_spy() throws Exception {

        when(mSpyCalculator.solve("any")).thenReturn("255");
        mSpyCalculator.solve("any");

        //passed spy test
        verify(mSpyCalculator).solve("any");

        //failed spy test
        //verify(mSpyCalculator).solve("000"); //different arguments

    }

    @After
    public void destroy() {

    }
}