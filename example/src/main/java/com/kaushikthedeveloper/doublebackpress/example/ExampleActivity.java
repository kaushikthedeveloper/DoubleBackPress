package com.kaushikthedeveloper.doublebackpress.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kaushikthedeveloper.doublebackpress.DoubleBackPress;
import com.kaushikthedeveloper.doublebackpress.helper.Callable;

public class ExampleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
    }

    Callable superBackPressed = new Callable() {
        @Override
        public void callableFunction() {
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
