package com.sujan.break_o_last;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.sujan.break_o_last.ui.profile.DeleteActivity;
import com.sujan.break_o_last.url.BaseUrl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.TestCase.assertTrue;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class UserDeleteTest {
    @Rule
    public ActivityTestRule<DeleteActivity>
            testRule = new ActivityTestRule<>(DeleteActivity.class);

    @Before
    public void setUp() {
        BaseUrl.Token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ijk4MTcwOTE3NTciLCJ1c2VybGV2ZWwiOiJzdXBlcmFkbWluIiwiaWF0IjoxNTgwODgyNTM5LCJleHAiOjE1ODA5MTg1Mzl9.QUnhpLLUsK9LW-FmwNRJ9g91wYcbRkcOvsH5Jw3oOUQ";
    }

    @Test
    public void checkNos() {
        onView(withId(R.id.delete))
                .perform(click());
        // This is another activity, no need to tell Espresso
        assertTrue(DeleteActivity.res);
    }
}