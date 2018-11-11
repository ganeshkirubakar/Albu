package com.albums.adapter;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.view.ViewGroup;

import com.albums.model.AlbumPhotos;
import com.albums.view.frament.AlbumDetailFragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class AlbumDetailsAdapterTest {

    @Mock
    private AlbumDetailFragment mockBaseActivity;
    private ArrayList<AlbumPhotos> albumDetailsList;

    private AlbumDetailsAdapter albumDetailsAdapterUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        albumDetailsList = new ArrayList<>();
        albumDetailsAdapterUnderTest = new AlbumDetailsAdapter(mockBaseActivity, albumDetailsList);
    }

    @Test
    public void testOnCreateViewHolder() {
        // Setup
        final ViewGroup parent = null;
        final int viewType = 0;
        final AlbumDetailsAdapter.AlbumListDetailsViewHolder expectedResult = null;

        // Run the test
        final AlbumDetailsAdapter.AlbumListDetailsViewHolder result = albumDetailsAdapterUnderTest.onCreateViewHolder(parent, viewType);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testOnBindViewHolder() {
        // Setup
        final AlbumDetailsAdapter.AlbumListDetailsViewHolder holder = null;
        final int position = 0;

        // Run the test
        albumDetailsAdapterUnderTest.onBindViewHolder(holder, position);

        // Verify the results
    }

    @Test
    public void testOnViewRecycled() {
        // Setup
        final AlbumDetailsAdapter.AlbumListDetailsViewHolder holder = null;

        // Run the test
        albumDetailsAdapterUnderTest.onViewRecycled(holder);

        // Verify the results
    }

    @Test
    public void testGetItemCount() {
        // Setup
        final int expectedResult = 0;

        // Run the test
        final int result = albumDetailsAdapterUnderTest.getItemCount();

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
