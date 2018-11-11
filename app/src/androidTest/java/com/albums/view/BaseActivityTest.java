package com.albums.view;

import android.content.Intent;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class BaseActivityTest {

    @Rule
    public ActivityTestRule<BaseActivity> activityTestRule = new ActivityTestRule<>(BaseActivity.class, false, false);

    @Test
    public void testLaunchActivity() {
        // Setup
        final Intent intent = new Intent();

        // Run the test
        activityTestRule.launchActivity(intent);

        // Verify the results
    }
}
