package com.kaushikthedeveloper.doublebackpress;

import android.app.Activity;
import android.content.Context;

import com.kaushikthedeveloper.doublebackpress.helper.FirstBackPressAction;
import com.kaushikthedeveloper.doublebackpress.helper.DoubleBackPressAction;

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
     * @param doublePressDuration   : duration of contention for the double back press (msec)
     * @param doubleBackPressAction : Action Interface - after DoubleBackPress occurs
     */
    public DoubleBackPress(Context context, int doublePressDuration, DoubleBackPressAction doubleBackPressAction) {
        flowManager.setDoublePressDuration(doublePressDuration);
        flowManager.setDoubleBackPressAction(doubleBackPressAction);
    }

    /**
     * Constructor
     * Should be used as Builder class with the .with... functions
     */
    public DoubleBackPress() {
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
     * Builder function for setting the action after DoubleBackPress function
     *
     * @param doubleBackPressAction : Action Interface - after DoubleBackPress occurs
     * @return DoubleBackPress
     */
    public DoubleBackPress withDoubleBackPressAction(DoubleBackPressAction doubleBackPressAction) {
        flowManager.setDoubleBackPressAction(doubleBackPressAction);
        return this;
    }

    /**
     * OPTIONAL
     * Display to be shown upon first back press
     *
     * @param firstBackPressAction : Action Interface - after 1st BackPress occurs
     * @return DoubleBackPress
     */
    public DoubleBackPress withFirstBackPressAction(FirstBackPressAction firstBackPressAction) {
        flowManager.setFirstBackPressAction(firstBackPressAction);
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

        // if Back press occurs within doublePressDuration => calls the application's DoubleBackPress Action
        if (flowManager.isFirstBackPressed()) {
            flowManager.getDoubleBackPressAction().actionCall();
            return;
        }

        firstBackPressOccurred();

        // Handler to reset the firstBackPressed flag after timeout(doublePressDuration)
        flowManager.resetBackPressFlagHandler();
    }

    /**
     * First back press occurred : set the FirstBackPressed flag
     * <p>
     * Also, in case user has set FirstBackPressAction, execute it
     */
    private void firstBackPressOccurred() {
        flowManager.setFirstBackPressed(true);
        if (flowManager.verifyFirstBackPressActionSet())
            flowManager.getFirstBackPressAction().actionCall();
    }
}
