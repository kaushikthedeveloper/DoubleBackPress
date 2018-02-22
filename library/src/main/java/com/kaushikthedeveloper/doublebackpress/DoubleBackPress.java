package com.kaushikthedeveloper.doublebackpress;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;

import com.kaushikthedeveloper.doublebackpress.helper.Callable;

/**
 * Double Back Press operation
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 04-02-2018.
 */
public class DoubleBackPress extends Activity {
    private Context context;
    private Callable superBackPress;
    private int doublePressDuration;

    private boolean singleBackPressOccurred;

    /**
     * Constructor
     *
     * @param context        : pass Application's context
     * @param doublePressDuration   : duration of contention for the double back press (msec)
     * @param superBackPress : Application's implementation of Back press
     */
    public DoubleBackPress(Context context, int doublePressDuration, Callable superBackPress) {
        this.context = context;
        this.doublePressDuration = doublePressDuration;
        this.superBackPress = superBackPress;
        this.singleBackPressOccurred = false;
    }

    /**
     * Constructor
     * Should be used as Builder class with the .with... functions
     */
    public DoubleBackPress() {
        this.singleBackPressOccurred = false;

        this.context = null;
        this.doublePressDuration = -1;
        this.superBackPress = null;
    }

    /**
     * Builder function for setting context
     *
     * @param context : pass Application's context
     * @return DoubleBackPress
     */
    public DoubleBackPress withContext(Context context) {
        this.context = context;
        return this;
    }


    /**
     * Builder function for setting the super.backpressed function
     *
     * @param superBackPressed : Application's implementation of Back press
     * @return DoubleBackPress
     */
    public DoubleBackPress withSuperBackPressed(Callable superBackPressed) {
        this.superBackPress = superBackPressed;
        return this;
    }

    /**
     * Builder function for setting the wait duration for the second back press (msec)
     *
     * @param waitDuration : duration of contention for the double back press
     * @return DoubleBackPress
     */
    public DoubleBackPress withWaitDuration(int waitDuration) {
        this.doublePressDuration = waitDuration;
        return this;
    }

    public DoubleBackPress withIntermediateDisplay() {
        return this;
    }

    /**
     * Overrides the Back press functionality
     */
    @Override
    public void onBackPressed() {
        // if Back press occurs within doublePressDuration , calls the super backPress method
        if (singleBackPressOccurred) {
            superBackPress.callableFunction();
            return;
        }

        // first back press occurred
        singleBackPressOccurred = true;

        resetBackPressFlagHandler();
    }

    /**
     * Handler which resets flag : singleBackPressOccurred
     * => when the second BackPress does not occur in the given period of time
     */
    private void resetBackPressFlagHandler() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                singleBackPressOccurred = false;
            }
        }, doublePressDuration);
    }
}
