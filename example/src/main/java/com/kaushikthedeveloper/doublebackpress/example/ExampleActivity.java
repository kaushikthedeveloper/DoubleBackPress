package com.kaushikthedeveloper.doublebackpress.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.kaushikthedeveloper.doublebackpress.DoubleBackPress;
import com.kaushikthedeveloper.doublebackpress.helper.IntermediateDisplay;
import com.kaushikthedeveloper.doublebackpress.helper.SuperBackPressCallable;
import com.kaushikthedeveloper.doublebackpress.setup.display.ToastDisplay;

public class ExampleActivity extends AppCompatActivity {
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        toast = Toast.makeText(this,"abc", Toast.LENGTH_SHORT);
    }

    SuperBackPressCallable superBackPressCallable = new SuperBackPressCallable() {
        @Override
        public void superBackPressFunction() {
            ExampleActivity.super.onBackPressed();
        }
    };


    IntermediateDisplay intermediateDisplay = new IntermediateDisplay() {
        @Override
        public void showIntermediateDisplay() {
            Toast.makeText(ExampleActivity.this, "Press back again", Toast.LENGTH_SHORT).show();
        }
    };

    DoubleBackPress doubleBackPress = new DoubleBackPress()
            .withContext(this)
            .withDoublePressDuration(2000)
            .withSuperBackPress(superBackPressCallable)
            .withIntermediateDisplay(intermediateDisplay)
            ;

    @Override
    public void onBackPressed() {
        doubleBackPress.onBackPressed();
    }
}