package com.sujan.break_o_last.ui.home;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class RoomActivityTest {

    @Rule
    public ActivityTestRule<RoomActivity> testRule = new ActivityTestRule<RoomActivity>(RoomActivity.class);
    RoomActivity roomActivity;

    @Before
    public void setUp() throws Exception {
        roomActivity = testRule.getActivity();
    }

    @Test
    public void TestComponent(){
        View view = roomActivity.bedNo;
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
    }
}