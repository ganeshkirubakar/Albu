package com.albums.adapter;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.view.ViewGroup;

import com.albums.model.Users;
import com.albums.view.frament.UserFragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class UserListAdapterTest {

    @Mock
    private UserFragment mockBaseActivity;
    private ArrayList<Users> userLists;

    private UserListAdapter userListAdapterUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        userLists = new ArrayList<>();
        userListAdapterUnderTest = new UserListAdapter(mockBaseActivity, userLists);
    }

    @Test
    public void testOnCreateViewHolder() {
        // Setup
        final ViewGroup parent = null;
        final int viewType = 0;
        final UserListAdapter.AlbumListViewHolder expectedResult = null;

        // Run the test
        final UserListAdapter.AlbumListViewHolder result = userListAdapterUnderTest.onCreateViewHolder(parent, viewType);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testOnBindViewHolder() {
        // Setup
        final UserListAdapter.AlbumListViewHolder holder = null;
        final int position = 0;

        // Run the test
        userListAdapterUnderTest.onBindViewHolder(holder, position);

        // Verify the results
    }

    @Test
    public void testGetItemCount() {
        // Setup
        final int expectedResult = 0;

        // Run the test
        final int result = userListAdapterUnderTest.getItemCount();

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
