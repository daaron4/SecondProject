package com.companyname.secondproject;

import android.app.Instrumentation;
import android.content.Context;
import android.test.AndroidTestCase;

import org.junit.Test;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest extends AndroidTestCase {

    private Context context;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        context = getContext();
    }

    @Test
    public void test() throws Exception {
        Instrumentation instrumentation = new Instrumentation();
        instrumentation.runOnMainSync(new Runnable() {
            @Override
            public void run() {
                int size = DataBaseHelper.getInstance(context).getStateData().getCount();
                assertEquals(50, size);
            }
        });
    }
}