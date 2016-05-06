package com.companyname.secondproject;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    private Context context;

    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        context = getSystemContext();
    }

    @SmallTest
    public void test() {
        int size = DataBaseHelper.getInstance(context).getStateData().getCount();
        assertEquals(50, size);
    }

}