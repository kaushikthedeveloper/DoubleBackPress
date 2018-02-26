package com.kaushikthedeveloper.doublebackpress.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.kaushikthedeveloper.doublebackpress.DoubleBackPress;
import com.kaushikthedeveloper.doublebackpress.helper.DoubleBackPressAction;
import com.kaushikthedeveloper.doublebackpress.helper.FirstBackPressAction;

public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
    }

    DoubleBackPressAction doubleBackPressAction = new DoubleBackPressAction() {
        @Override
        public void actionCall() {
            ExampleActivity.super.onBackPressed();
        }
    };

    FirstBackPressAction firstBackPressAction = new FirstBackPressAction() {
        @Override
        public void actionCall() {
            Toast.makeText(ExampleActivity.this, "Press back again", Toast.LENGTH_SHORT).show();
        }
    };

    DoubleBackPress doubleBackPress = new DoubleBackPress()
            .withDoublePressDuration(2000)
            .withDoubleBackPressAction(doubleBackPressAction)
            .withFirstBackPressAction(firstBackPressAction);

    @Override
    public void onBackPressed() {
        doubleBackPress.onBackPressed();
    }
}