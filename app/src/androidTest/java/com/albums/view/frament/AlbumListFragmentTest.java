package com.albums.view.frament;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class AlbumListFragmentTest {

    private AlbumListFragment albumListFragmentUnderTest;

    @Before
    public void setUp() {
        albumListFragmentUnderTest = new AlbumListFragment();
    }

    @Test
    public void testShowProgress() {
        // Setup

        // Run the test
        albumListFragmentUnderTest.showProgress();

        // Verify the results
    }

    @Test
    public void testHideProgress() {
        // Setup

        // Run the test
        albumListFragmentUnderTest.hideProgress();

        // Verify the results
    }

    @Test
    public void testShowEmptyView() {
        // Setup
        final int visibility = 0;

        // Run the test
        albumListFragmentUnderTest.showEmptyView(visibility);

        // Verify the results
    }

    @Test
    public void testSetDataToRecyclerView() {
        // Setup
        final ArrayList<?> albumArrayList = new ArrayList<>(Arrays.asList());

        // Run the test
        albumListFragmentUnderTest.setDataToRecyclerView(albumArrayList);

        // Verify the results
    }

    @Test
    public void testOnResponseFailure() {
        // Setup
        final String message = "message";

        // Run the test
        albumListFragmentUnderTest.onResponseFailure(message);

        // Verify the results
    }

    @Test
    public void testOnItemClick() {
        // Setup
        final int position = 0;

        // Run the test
        albumListFragmentUnderTest.onItemClick(position);

        // Verify the results
    }

    @Test
    public void testOnRefresh() {
        // Setup

        // Run the test
        albumListFragmentUnderTest.onRefresh();

        // Verify the results
    }

    @Test
    public void testNewInstance() {
        // Setup
        final AlbumListFragment expectedResult = null;

        // Run the test
        final AlbumListFragment result = AlbumListFragment.newInstance();

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
