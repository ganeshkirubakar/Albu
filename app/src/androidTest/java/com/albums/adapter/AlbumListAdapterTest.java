package com.albums.adapter;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.view.ViewGroup;

import com.albums.model.Album;
import com.albums.view.frament.AlbumListFragment;

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
public class AlbumListAdapterTest {

    @Mock
    private AlbumListFragment mockBaseActivity;
    private ArrayList<Album> albumList;

    private AlbumListAdapter albumListAdapterUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        albumList = new ArrayList<>();
        albumListAdapterUnderTest = new AlbumListAdapter(mockBaseActivity, albumList);
    }

    @Test
    public void testOnCreateViewHolder() {
        // Setup
        final ViewGroup parent = null;
        final int viewType = 0;
        final AlbumListAdapter.AlbumListViewHolder expectedResult = null;

        // Run the test
        final AlbumListAdapter.AlbumListViewHolder result = albumListAdapterUnderTest.onCreateViewHolder(parent, viewType);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testOnBindViewHolder() {
        // Setup
        final AlbumListAdapter.AlbumListViewHolder holder = null;
        final int position = 0;

        // Run the test
        albumListAdapterUnderTest.onBindViewHolder(holder, position);

        // Verify the results
    }

    @Test
    public void testGetItemCount() {
        // Setup
        final int expectedResult = 0;

        // Run the test
        final int result = albumListAdapterUnderTest.getItemCount();

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
