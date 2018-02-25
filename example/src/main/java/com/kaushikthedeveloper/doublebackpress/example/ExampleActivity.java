package com.kaushikthedeveloper.doublebackpress.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kaushikthedeveloper.doublebackpress.DoubleBackPress;
import com.kaushikthedeveloper.doublebackpress.helper.SuperBackPressCallable;

public class ExampleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
    }

    SuperBackPressCallable superBackPressCallable = new SuperBackPressCallable() {
        @Override
        public void superBackPressFunction() {
            ExampleActivity.super.onBackPressed();
        }
    };
    DoubleBackPress doubleBackPress = new DoubleBackPress()
            .withContext(this)
            .withDoublePressDuration(2000)
            .withSuperBackPress(superBackPressCallable);

    @Override
    public void onBackPressed() {
        doubleBackPress.onBackPressed();
    }
}