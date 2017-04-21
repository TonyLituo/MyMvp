package com.dhcc.mvp.ui.home;


import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;


/**
 * Created by Lituo on 2017/4/10 0010. 10:37 .
 * Mail：tony1994_vip@163.com
 */

public class TestActivity extends AppCompatActivity {


    private static class MyHandler extends Handler {
        private WeakReference<TestActivity> activityWeakReference;

        public MyHandler(TestActivity activity) {
            activityWeakReference = new WeakReference(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            TestActivity activity = activityWeakReference.get();
            if (activity != null) {
            }
        }
    }


}
