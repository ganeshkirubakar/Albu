package com.albums.service;

import android.content.Context;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.albums.contract.AlbumListContract;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class AlbumListServiceTest {

    private AlbumListService albumListServiceUnderTest;

    @Before
    public void setUp() {
        albumListServiceUnderTest = new AlbumListService();
    }

    @Test
    public void testGetAlbumList() {
        // Setup
        final Context context = null;
        final AlbumListContract.Model.OnFinishedListener onFinishedListener = null;

        // Run the test
        albumListServiceUnderTest.getAlbumList(context, onFinishedListener);

        // Verify the results
    }

    @Test
    public void testGetAlbumDetail() {
        // Setup
        final Context context = null;
        final AlbumListContract.Model.OnFinishedListener onFinishedListener = null;
        final int id = 0;

        // Run the test
        albumListServiceUnderTest.getAlbumDetail(context, onFinishedListener, id);

        // Verify the results
    }

    @Test
    public void testGetAlbumDetailsWitID() {
        // Setup
        final Context context = null;
        final AlbumListContract.Model.OnFinishedListener onFinishedListener = null;
        final int id = 0;

        // Run the test
        albumListServiceUnderTest.getAlbumDetailsWitID(context, onFinishedListener, id);

        // Verify the results
    }

    @Test
    public void testDeleteAlbum() {
        // Setup
        final Context context = null;
        final AlbumListContract.Model.OnFinishedListener onFinishedListener = null;
        final int id = 0;

        // Run the test
        albumListServiceUnderTest.deleteAlbum(context, onFinishedListener, id);

        // Verify the results
    }

    @Test
    public void testGetAlbumListFromDatabase() {
        // Setup
        final Context context = null;
        final AlbumListContract.Model.OnFinishedListener onFinishedListener = null;

        // Run the test
        albumListServiceUnderTest.getAlbumListFromDatabase(context, onFinishedListener);

        // Verify the results
    }

    @Test
    public void testGetAlbumListFromDatabaseWithAlbumId() {
        // Setup
        final Context context = null;
        final AlbumListContract.Model.OnFinishedListener onFinishedListener = null;
        final int id = 0;

        // Run the test
        albumListServiceUnderTest.getAlbumListFromDatabaseWithAlbumId(context, onFinishedListener, id);

        // Verify the results
    }
}
