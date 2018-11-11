package com.albums.presenter;

import android.content.Context;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.albums.contract.AlbumListContract;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class AlbumListPresenterTest {

    private AlbumListContract.View albumListView;

    private AlbumListPresenter albumListPresenterUnderTest;

    @Before
    public void setUp() {
        albumListView = null;
        albumListPresenterUnderTest = new AlbumListPresenter(albumListView);
    }

    @Test
    public void testOnSuccess() {
        // Setup
        final ArrayList<?> response = new ArrayList<>(Arrays.asList());

        // Run the test
        albumListPresenterUnderTest.onSuccess(response);

        // Verify the results
    }

    @Test
    public void testOnDeleteSuccess() {
        // Setup

        // Run the test
        albumListPresenterUnderTest.onDeleteSuccess();

        // Verify the results
    }

    @Test
    public void testOnError() {
        // Setup
        final String message = "message";

        // Run the test
        albumListPresenterUnderTest.onError(message);

        // Verify the results
    }

    @Test
    public void testRequestDataFromServer() {
        // Setup
        final Context context = null;
        final int type = 0;
        final int id = 0;

        // Run the test
        albumListPresenterUnderTest.requestDataFromServer(context, type, id);

        // Verify the results
    }

    @Test
    public void testRequestDataFromDatabase() {
        // Setup
        final Context context = null;
        final int type = 0;
        final int id = 0;

        // Run the test
        albumListPresenterUnderTest.requestDataFromDatabase(context, type, id);

        // Verify the results
    }

    @Test
    public void testDeleteAlbum() {
        // Setup
        final Context context = null;
        final int id = 0;

        // Run the test
        albumListPresenterUnderTest.deleteAlbum(context, id);

        // Verify the results
    }
}
