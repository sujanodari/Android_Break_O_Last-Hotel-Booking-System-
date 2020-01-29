package com.sujan.break_o_last;

import androidx.test.espresso.ViewAction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.sujan.break_o_last.url.BaseUrl;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.TestCase.assertEquals;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RegistrationTest {
    @Rule
    public ActivityTestRule<LoginActivity>
            testRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void checkNos()
    {
       // onView(withId(R.id.profileImage))
            //    .perform(withInputType();
        onView(withId(R.id.uname))
                .perform(typeText("Sujan Odari"));
        onView(withId(R.id.number))
                .perform(typeText("9817091757"));
        onView(withId(R.id.address))
                .perform(typeText("Gatthaghar"));
        onView(withId(R.id.email))
                .perform(typeText("odarisujan@gmail.com"));
        onView(withId(R.id.password))
                .perform(typeText("sujan"));
        onView(withId(R.id.cpassword))
                .perform(typeText("sujan"));
        onView(withId(R.id.male))
                .perform((ViewAction) isChecked());
        onView(withId(R.id.register))
                .perform(click());
        // This is another activity, no need to tell Espresso
        assertEquals("success",BaseUrl.Status);
    }

}


