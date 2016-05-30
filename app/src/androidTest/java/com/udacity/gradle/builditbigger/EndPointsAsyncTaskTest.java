package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.InstrumentationTestCase;
import android.test.mock.MockContext;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */


public class EndPointsAsyncTaskTest extends InstrumentationTestCase {
    String response;
    public EndPointsAsyncTaskTest() {
        super();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public final void testSuccessfulFetch() throws Throwable {
        // create  a signal to let us know when our task is done.
        final CountDownLatch signal = new CountDownLatch(1);

        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {


                new EndpointsAsyncTask() {
                    @Override
                    protected void onPostExecute(String result) {
                        response=result;
                        signal.countDown();
                    }
                }.execute(new MockContext());
            }
        });



        signal.await(10, TimeUnit.SECONDS);
        assertNotNull(response);
    }

}