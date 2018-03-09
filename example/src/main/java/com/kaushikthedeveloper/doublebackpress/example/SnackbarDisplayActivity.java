package com.kaushikthedeveloper.doublebackpress.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kaushikthedeveloper.doublebackpress.DoubleBackPress;
import com.kaushikthedeveloper.doublebackpress.helper.DoubleBackPressAction;
import com.kaushikthedeveloper.doublebackpress.helper.FirstBackPressAction;
import com.kaushikthedeveloper.doublebackpress.setup.display.SnackbarDisplay;

/**
 * SnackbarDisplay on FirstBackPress + default back press behaviour on SecondBackPress
 */
public class SnackbarDisplayActivity extends AppCompatActivity {
    FirstBackPressAction firstBackPressAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar_display);

        // set SnackbarDisplay Action on FirstBackPress
        // IMP : Below two lines of code should always be called after setContentView() is called
        firstBackPressAction = new SnackbarDisplay().standard(findViewById(R.id.parentView),
                "Press again to call default back behaviour");
        doubleBackPress.setFirstBackPressAction(firstBackPressAction);
    }

    // set the Action on DoubleBackPress : call the default back press behaviour
    DoubleBackPressAction doubleBackPressAction = new DoubleBackPressAction() {
        @Override
        public void actionCall() {
            SnackbarDisplayActivity.super.onBackPressed();
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
