package com.albums.view.frament;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.albums.model.Users;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class UserFragmentTest {

    private UserFragment userFragmentUnderTest;

    @Before
    public void setUp() {
        userFragmentUnderTest = new UserFragment();
    }

    @Test
    public void testShowProgress() {
        // Setup

        // Run the test
        userFragmentUnderTest.showProgress();

        // Verify the results
    }

    @Test
    public void testHideProgress() {
        // Setup

        // Run the test
        userFragmentUnderTest.hideProgress();

        // Verify the results
    }

    @Test
    public void testShowEmptyView() {
        // Setup
        final int visibility = 0;

        // Run the test
        userFragmentUnderTest.showEmptyView(visibility);

        // Verify the results
    }

    @Test
    public void testShowUserDetail() {
        // Setup
        final ArrayList<Users> usersArrayList = new ArrayList<>();

        // Run the test
        userFragmentUnderTest.showUserDetail(usersArrayList);

        // Verify the results
    }

    @Test
    public void testOnResponseFailure() {
        // Setup
        final String message = "message";

        // Run the test
        userFragmentUnderTest.onResponseFailure(message);

        // Verify the results
    }

    @Test
    public void testOnRefresh() {
        // Setup

        // Run the test
        userFragmentUnderTest.onRefresh();

        // Verify the results
    }

    @Test
    public void testNewInstance() {
        // Setup
        final UserFragment expectedResult = null;

        // Run the test
        final UserFragment result = UserFragment.newInstance();

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
