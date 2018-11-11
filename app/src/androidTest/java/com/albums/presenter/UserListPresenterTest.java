package com.albums.presenter;

import android.content.Context;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.albums.contract.UserListContract;
import com.albums.model.Users;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class UserListPresenterTest {

    private UserListContract.View userListView;

    private UserListPresenter userListPresenterUnderTest;

    @Before
    public void setUp() {
        userListView = null;
        userListPresenterUnderTest = new UserListPresenter(userListView);
    }

    @Test
    public void testOnDestoryView() {
        // Setup

        // Run the test
        userListPresenterUnderTest.onDestoryView();

        // Verify the results
    }

    @Test
    public void testRequestDataFromServer() {
        // Setup
        final Context context = null;

        // Run the test
        userListPresenterUnderTest.requestDataFromServer(context);

        // Verify the results
    }

    @Test
    public void testRequestDataFromDB() {
        // Setup
        final Context context = null;

        // Run the test
        userListPresenterUnderTest.requestDataFromDB(context);

        // Verify the results
    }

    @Test
    public void testOnSuccess() {
        // Setup
        final ArrayList<Users> usersArrayList = new ArrayList<>();

        // Run the test
        userListPresenterUnderTest.onSuccess(usersArrayList);

        // Verify the results
    }

    @Test
    public void testOnError() {
        // Setup
        final String message = "message";

        // Run the test
        userListPresenterUnderTest.onError(message);

        // Verify the results
    }
}
