
package com.example.testactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class TestActivity extends Activity {
    static final int MSG_TO_FINISH = 1;
    Handler mHandler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == MSG_TO_FINISH) {
                finish();
            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("test", this + ", onCreate");
        super.onCreate(savedInstanceState);
        processIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.i("test", this + ", onNewIntent");
        super.onNewIntent(intent);
        setIntent(intent);
        processIntent(intent);
    }

    private void processIntent(Intent intent) {
        if (intent != null && intent.getAction() != null) {
            if (intent.getAction().equals("com.test.start")) {
                Log.i("test", this + ", processIntent, action = start");
                mHandler.removeMessages(MSG_TO_FINISH);
            } else if (intent.getAction().equals("com.test.stop")) {
                Log.i("test", this + ", processIntent, action = stop, to finish ...");
                mHandler.sendEmptyMessageDelayed(MSG_TO_FINISH, 500);
            }

        } else {
            Log.i("test", this + ", processIntent, action = NULL");
        }
    }

    @Override
    protected void onDestroy() {
        Log.i("test", this + ", onDestroy");
        super.onDestroy();
    }

}
