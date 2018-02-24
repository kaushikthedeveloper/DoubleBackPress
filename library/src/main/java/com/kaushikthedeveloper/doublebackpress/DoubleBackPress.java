package com.kaushikthedeveloper.doublebackpress;

import android.app.Activity;
import android.content.Context;

import com.kaushikthedeveloper.doublebackpress.helper.Callable;
import com.kaushikthedeveloper.doublebackpress.setup.FlowManager;

/**
 * Double Back Press operation
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 04-02-2018.
 */
public class DoubleBackPress extends Activity {
    FlowManager flowManager = new FlowManager();

    /**
     * Constructor
     *
     * @param context        : pass Application's context
     * @param doublePressDuration   : duration of contention for the double back press (msec)
     * @param superBackPress : Application's implementation of Back press
     */
    public DoubleBackPress(Context context, int doublePressDuration, Callable superBackPress) {
        flowManager.setContext(context);
        flowManager.setDoublePressDuration(doublePressDuration);
        flowManager.setSuperBackPress(superBackPress);
        flowManager.setFirstBackPressed(false);
    }

    /**
     * Constructor
     * Should be used as Builder class with the .with... functions
     */
    public DoubleBackPress() {
    }

    /**
     * Builder function for setting context
     *
     * @param context : pass Application's context
     * @return DoubleBackPress
     */
    public DoubleBackPress withContext(Context context) {
        this.flowManager.setContext(context);
        return this;
    }


    /**
     * Builder function for setting the wait duration for the second back press (msec)
     *
     * @param doublePressDuration : duration of contention for the double back press
     * @return DoubleBackPress
     */
    public DoubleBackPress withDoublePressDuration(int doublePressDuration) {
        flowManager.setDoublePressDuration(doublePressDuration);
        return this;
    }

    /**
     * Builder function for setting the super.backpressed function
     *
     * @param superBackPress : Application's implementation of Back press
     * @return DoubleBackPress
     */
    public DoubleBackPress withSuperBackPressed(Callable superBackPress) {
        flowManager.setSuperBackPress(superBackPress);
        return this;
    }

    /**
     * Overrides the Back press functionality
     */
    @Override
    public void onBackPressed() {
        // if Back press occurs within doublePressDuration , calls the super backPress method
        if (flowManager.isFirstBackPressed()) {
            flowManager.getSuperBackPress().callableFunction();
            return;
        }

        firstBackPressOccurred();

        // Handler to reset the firstBackPressed flag after countdown
        flowManager.resetBackPressFlagHandler();
    }

    /**
     * First back press occurred
     */
    private void firstBackPressOccurred(){
        flowManager.setFirstBackPressed(true);
    }
}
