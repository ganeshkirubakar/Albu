package com.albums.utils;

import android.content.Context;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class DialogUtilsTest {

    private DialogUtils dialogUtilsUnderTest;

    @Before
    public void setUp() {
        dialogUtilsUnderTest = DialogUtils.getInstance();
    }

    @Test
    public void testShowAlertDialog() {
        // Setup
        final Context context = null;
        final String message = "message";

        // Run the test
        dialogUtilsUnderTest.showAlertDialog(context, message);

        // Verify the results
    }

    @Test
    public void testGetInstance() {
        // Setup
        final DialogUtils expectedResult = null;

        // Run the test
        final DialogUtils result = DialogUtils.getInstance();

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
