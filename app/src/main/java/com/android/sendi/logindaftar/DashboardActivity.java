package com.android.sendi.logindaftar;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class DashboardActivity extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("My Tag", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("My Tag", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("My Tag", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("My Tag", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("My Tag", "onDestroy");
    }
}
