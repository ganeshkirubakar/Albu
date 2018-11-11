package com.albums.view.frament;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.view.MenuItem;
import android.view.View;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class AlbumDetailFragmentTest {

    private AlbumDetailFragment albumDetailFragmentUnderTest;

    @Before
    public void setUp() {
        albumDetailFragmentUnderTest = new AlbumDetailFragment();
    }

    @Test
    public void testShowProgress() {
        // Setup

        // Run the test
        albumDetailFragmentUnderTest.showProgress();

        // Verify the results
    }

    @Test
    public void testHideProgress() {
        // Setup

        // Run the test
        albumDetailFragmentUnderTest.hideProgress();

        // Verify the results
    }

    @Test
    public void testShowEmptyView() {
        // Setup
        final int visibility = 0;

        // Run the test
        albumDetailFragmentUnderTest.showEmptyView(visibility);

        // Verify the results
    }

    @Test
    public void testSetDataToRecyclerView() {
        // Setup
        final ArrayList<?> albumArrayList = new ArrayList<>(Arrays.asList());

        // Run the test
        albumDetailFragmentUnderTest.setDataToRecyclerView(albumArrayList);

        // Verify the results
    }

    @Test
    public void testOnResponseFailure() {
        // Setup
        final String message = "message";

        // Run the test
        albumDetailFragmentUnderTest.onResponseFailure(message);

        // Verify the results
    }

    @Test
    public void testOnItemClick() {
        // Setup
        final int position = 0;

        // Run the test
        albumDetailFragmentUnderTest.onItemClick(position);

        // Verify the results
    }

    @Test
    public void testOnClick() {
        // Setup
        final View v = null;

        // Run the test
        albumDetailFragmentUnderTest.onClick(v);

        // Verify the results
    }

    @Test
    public void testOnContextItemSelected() {
        // Setup
        final MenuItem item = null;
        final boolean expectedResult = false;

        // Run the test
        final boolean result = albumDetailFragmentUnderTest.onContextItemSelected(item);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testOnRefresh() {
        // Setup

        // Run the test
        albumDetailFragmentUnderTest.onRefresh();

        // Verify the results
    }

    @Test
    public void testNewInstance() {
        // Setup
        final int id = 0;
        final AlbumDetailFragment expectedResult = null;

        // Run the test
        final AlbumDetailFragment result = AlbumDetailFragment.newInstance(id);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
