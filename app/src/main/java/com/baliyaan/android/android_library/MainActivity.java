package com.baliyaan.android.android_library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.baliyaan.android.library.web.MyCallbackInterface;
import com.baliyaan.android.library.web.MyWebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyWebView myWebView = new MyWebView(this, "", new MyCallbackInterface() {
            @Override
            public void Call(String msg) {
                Log.i("LibraryAppModule","I'm called!");
            }
        });
    }
}
