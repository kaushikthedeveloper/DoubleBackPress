package com.kaushikthedeveloper.doublebackpress.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kaushikthedeveloper.doublebackpress.DoubleBackPress;
import com.kaushikthedeveloper.doublebackpress.OverrideSuperBackPressed;

public class ExampleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
    }

    OverrideSuperBackPressed superBackPressed = new OverrideSuperBackPressed() {
        @Override
        public void overriddenSuper() {
            ExampleActivity.super.onBackPressed();
        }
    };
    DoubleBackPress doubleBackPress = new DoubleBackPress()
            .withContext(this)
            .withIntermMsg("Double Back Press")
            .withWaitDuration(5000)
            .withSuperBackPressed(superBackPressed);

    @Override
    public void onBackPressed() {
        doubleBackPress.onBackPressed();
    }
}
