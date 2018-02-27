package com.kaushikthedeveloper.doublebackpress.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kaushikthedeveloper.doublebackpress.DoubleBackPress;
import com.kaushikthedeveloper.doublebackpress.helper.DoubleBackPressAction;
import com.kaushikthedeveloper.doublebackpress.helper.FirstBackPressAction;
import com.kaushikthedeveloper.doublebackpress.setup.display.SnackbarDisplay;

public class ExampleActivity extends AppCompatActivity {
    FirstBackPressAction firstBackPressAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        firstBackPressAction = new SnackbarDisplay().standard(getCurrentFocus());
        doubleBackPress.setFirstBackPressAction(firstBackPressAction);
    }

    DoubleBackPressAction doubleBackPressAction = new DoubleBackPressAction() {
        @Override
        public void actionCall() {
            ExampleActivity.super.onBackPressed();
        }
    };

//    FirstBackPressAction firstBackPressAction = new FirstBackPressAction() {
//        @Override
//        public void actionCall() {
//            Toast.makeText(ExampleActivity.this, "Press back again", Toast.LENGTH_SHORT).show();
//        }
//    };

    DoubleBackPress doubleBackPress = new DoubleBackPress()
            .withDoublePressDuration(2000)
            .withDoubleBackPressAction(doubleBackPressAction);

    @Override
    public void onBackPressed() {
        doubleBackPress.onBackPressed();
    }
}