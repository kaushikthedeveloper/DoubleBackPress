package com.kaushikthedeveloper.doublebackpress.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kaushikthedeveloper.doublebackpress.DoubleBackPress;
import com.kaushikthedeveloper.doublebackpress.helper.DoubleBackPressAction;
import com.kaushikthedeveloper.doublebackpress.helper.FirstBackPressAction;
import com.kaushikthedeveloper.doublebackpress.setup.display.ToastDisplay;

/**
 * ToastDisplay on FirstBackPress + exit on SecondBackPress
 */
public class ToastDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_display);
    }

    // set the ToastDisplay to be shown on FirstBackPress
    FirstBackPressAction firstBackPressAction = new ToastDisplay().standard(this, "Press again to close current Activity");

    // set the Action on DoubleBackPress
    DoubleBackPressAction doubleBackPressAction = new DoubleBackPressAction() {
        @Override
        public void actionCall() {
            finish();
            System.exit(0);
        }
    };

    // setup DoubleBackPress behaviour : close the current Activity
    DoubleBackPress doubleBackPress = new DoubleBackPress()
            .withDoublePressDuration(3000)
            .withFirstBackPressAction(firstBackPressAction)
            .withDoubleBackPressAction(doubleBackPressAction);

    /**
     * Override the onBackPressed with DoubleBackPress behaviour for back press
     */
    @Override
    public void onBackPressed() {
        doubleBackPress.onBackPressed();
    }
}
