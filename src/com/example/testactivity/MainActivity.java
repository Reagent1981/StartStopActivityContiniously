
package com.example.testactivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnClickListener listener = new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (v.getId() == R.id.button1) {
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            start();
                            stop();
                            start();
                            stop();
                            start();
//                            stop();
//                            start();
//                            stop();
//                            start();
//                            stop();
//                            start();
//                            stop();
                        }

                    }).start();
                } else if (v.getId() == R.id.button2) {
                    stop();
                }
            }

        };

        findViewById(R.id.button1).setOnClickListener(listener);
        findViewById(R.id.button2).setOnClickListener(listener);
    }

    private void start() {
        Log.w("test", "to start");
        // Intent intent = new Intent(MainActivity.this, TestActivity.class);
        Intent intent = new Intent();
        intent.setAction("com.test.start");
        // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void stop() {
        Log.e("test", "to stop");
        // Intent intent = new Intent(MainActivity.this, TestActivity.class);
        Intent intent = new Intent();
        intent.setAction("com.test.stop");
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
