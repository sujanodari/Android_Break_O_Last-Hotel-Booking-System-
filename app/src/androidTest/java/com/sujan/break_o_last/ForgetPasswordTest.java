package com.sujan.break_o_last;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.sujan.break_o_last.ui.registration.ForgetActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertTrue;


    @RunWith(AndroidJUnit4.class)
    @LargeTest
    public class ForgetPasswordTest {
        @Rule
        public ActivityTestRule<ForgetActivity>
                testRule = new ActivityTestRule<>(ForgetActivity.class);

        @Test
        public void checkUpdate()
        {
            onView(withId(R.id.uusername))
                    .perform(typeText("9815040894"));
            onView(withId(R.id.upassword))
                    .perform(typeText("sujan123"));
            onView(withId(R.id.update))
                    .perform(click());
            // This is another activity, no need to tell Espresso
            assertTrue(ForgetActivity.res);
        }
    }



