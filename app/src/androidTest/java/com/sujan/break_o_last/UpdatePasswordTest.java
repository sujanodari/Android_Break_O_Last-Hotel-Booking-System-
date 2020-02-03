package com.sujan.break_o_last;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.sujan.break_o_last.ui.profile.ProfileFragment;
import com.sujan.break_o_last.url.BaseUrl;

import org.junit.Before;
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
    public class  UpdatePasswordTest {
        @Rule
        public ActivityTestRule<DashboardActivity>
                testRule = new ActivityTestRule<>(DashboardActivity.class);
        @Before
        public  void setUp(){
            BaseUrl.Token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ijk4MTcwOTE3NTciLCJ1c2VybGV2ZWwiOiJzdXBlcmFkbWluIiwiaWF0IjoxNTgwMzA3NTI3LCJleHAiOjE1ODAzNDM1Mjd9.WFjPA_UyeDni0wc-pN2OP8qZx4GcjO2vOGicMKU5q9g";
        }
        @Before
        public  void ProfileFragment(){
         testRule.getActivity()
         .getFragmentManager().beginTransaction();
        }
        @Test
        public void checkNos()
        {
            onView(withId(R.id.etUPassword))
                    .perform(typeText("Sujan123"));
            onView(withId(R.id.btnUpdate))
                    .perform(click());
            // This is another activity, no need to tell Espresso
            assertTrue(ProfileFragment.res);
        }
    }



