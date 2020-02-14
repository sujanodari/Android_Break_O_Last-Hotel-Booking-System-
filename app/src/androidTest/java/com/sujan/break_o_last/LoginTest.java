package com.sujan.break_o_last;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.sujan.break_o_last.url.BaseUrl;

import org.hamcrest.core.IsNull;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
    @LargeTest
    public class LoginTest {
        @Rule
        public ActivityTestRule<LoginActivity>
                testRule = new ActivityTestRule<>(LoginActivity.class);

        @Test
        public void checkNos()
        {
            onView(withId(R.id.username))
                    .perform(typeText("123412341234"));
            onView(withId(R.id.password))
                    .perform(typeText("sujan"));
            onView(withId(R.id.login))
                    .perform(click());
            // This is another activity, no need to tell Espresso
            assertThat(BaseUrl.Token,is(IsNull.notNullValue()));
            }
    }



