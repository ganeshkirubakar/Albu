package com.albums.utils;

import android.content.Context;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class RealmDatabaseTest {

    @Test
    public void testGetRealmDatabase() {
        // Setup
        final Context context = null;
        final RealmDatabase expectedResult = null;

        // Run the test
        final RealmDatabase result = RealmDatabase.getRealmDatabase(context);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
