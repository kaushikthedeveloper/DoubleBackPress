package com.kaushikthedeveloper.doublebackpress;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.kaushikthedeveloper.doublebackpress.helper.IntermediateDisplay;
import com.kaushikthedeveloper.doublebackpress.helper.SuperBackPressCallable;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 04-02-2018.
 * <p>
 * Double Back Press
 */
public class DoubleBackPress extends Activity {
    FlowManager flowManager = new FlowManager();

    /**
     * Constructor
     *
     * @param context             : pass Application's context
     * @param doublePressDuration : duration of contention for the double back press (msec)
     * @param superBackPress      : Application's implementation of Back press
     */
    public DoubleBackPress(Context context, int doublePressDuration, SuperBackPressCallable superBackPress) {
        flowManager.setContext(context);
        flowManager.setDoublePressDuration(doublePressDuration);
        flowManager.setSuperBackPress(superBackPress);
    }

    /**
     * Constructor
     * Should be used as Builder class with the .with... functions
     */
    public DoubleBackPress() {
    }

    /**
     * REQUIRED
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
     * REQUIRED
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
     * REQUIRED
     * Builder function for setting the super.backpressed function
     *
     * @param superBackPress : Application's implementation of Back press
     * @return DoubleBackPress
     */
    public DoubleBackPress withSuperBackPress(SuperBackPressCallable superBackPress) {
        flowManager.setSuperBackPress(superBackPress);
        return this;
    }

    /**
     * OPTIONAL
     * Display to be shown upon first back press
     *
     * @param intermediateDisplay : Element to be displayed after the First Back Press
     * @return DoubleBackPress
     */
    public DoubleBackPress withIntermediateDisplay(IntermediateDisplay intermediateDisplay) {
        flowManager.setIntermediateDisplay(intermediateDisplay);
        return this;
    }


    /**
     * MAIN FUNCTION : all the required operations happen from here
     * <p>
     * Overrides the Back press functionality
     */
    @Override
    public void onBackPressed() {
        // check that all required variables have been set
        flowManager.checkRequiredVariablesSet();

        // if Back press occurs within doublePressDuration : calls the application's super.onBackPressed()
        if (flowManager.isFirstBackPressed()) {
            flowManager.getSuperBackPress().superBackPressFunction();
            return;
        }

        firstBackPressOccurred();

        // Handler to reset the firstBackPressed flag after timeout(doublePressDuration)
        flowManager.resetBackPressFlagHandler();
    }

    /**
     * First back press occurred : set the FirstBackPressed flag
     * <p>
     * Also, in case user has set IntermediateDisplay, display it
     */
    private void firstBackPressOccurred() {
        flowManager.setFirstBackPressed(true);
//        Toast.makeText(flowManager.getContext(), "1", Toast.LENGTH_SHORT).show();
        if (flowManager.verifyIntermediateDisplaySet())
            flowManager.getIntermediateDisplay().showIntermediateDisplay();
    }
}
