package com.sujan.break_o_last;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class LoginActivityUserFieldTest {

    @Rule
    public ActivityTestRule<LoginActivity> testRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);
    LoginActivity loginActivity;

    @Before
    public void setUp() throws Exception {
        loginActivity = testRule.getActivity();
    }

    @Test
    public void TestComponent() {
        View view = loginActivity.Username;
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
    }
}