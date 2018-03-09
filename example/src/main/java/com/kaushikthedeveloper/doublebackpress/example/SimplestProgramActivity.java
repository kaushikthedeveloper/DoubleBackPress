package com.kaushikthedeveloper.doublebackpress.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.kaushikthedeveloper.doublebackpress.DoubleBackPress;
import com.kaushikthedeveloper.doublebackpress.helper.DoubleBackPressAction;

/**
 * Toast on SecondBackPress
 */
public class SimplestProgramActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplest_program);
    }

    // set the Action to occur on DoubleBackPress
    DoubleBackPressAction doubleBackPressAction = new DoubleBackPressAction() {
        @Override
        public void actionCall() {
            Toast.makeText(SimplestProgramActivity.this, "DoubleBackPress press occurred", Toast.LENGTH_SHORT).show();
        }
    };

    // setup DoubleBackPress behaviour
    DoubleBackPress doubleBackPress = new DoubleBackPress()
            .withDoublePressDuration(3000)
            .withDoubleBackPressAction(doubleBackPressAction);

    /**
     * Override the onBackPressed with DoubleBackPress behaviour for back press
     */
    @Override
    public void onBackPressed() {
        doubleBackPress.onBackPressed();
    }
}
