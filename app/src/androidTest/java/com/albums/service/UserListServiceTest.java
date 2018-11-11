package com.albums.service;

import android.content.Context;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.albums.contract.UserListContract;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class UserListServiceTest {

    private UserListService userListServiceUnderTest;

    @Before
    public void setUp() {
        userListServiceUnderTest = new UserListService();
    }

    @Test
    public void testGetUserDetails() {
        // Setup
        final Context context = null;
        final UserListContract.Model.onFinishedListener onFinishedListener = null;

        // Run the test
        userListServiceUnderTest.getUserDetails(context, onFinishedListener);

        // Verify the results
    }

    @Test
    public void testGetUserDetailsFromDB() {
        // Setup
        final Context context = null;
        final UserListContract.Model.onFinishedListener onFinishedListener = null;

        // Run the test
        userListServiceUnderTest.getUserDetailsFromDB(context, onFinishedListener);

        // Verify the results
    }
}
