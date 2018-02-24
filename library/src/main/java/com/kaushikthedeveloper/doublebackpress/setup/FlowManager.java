package com.kaushikthedeveloper.doublebackpress.setup;

import android.os.Handler;

import com.kaushikthedeveloper.doublebackpress.setup.errors.ErrorsManager;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 21-02-2018.
 * <p>
 * Manage the state of the DoubleBackPress module
 */
public class FlowManager extends RequirementsConsolidator {
    private boolean firstBackPressed;

    /**
     * At the start, no Back press has occurred
     */
    public FlowManager() {
        firstBackPressed = false;
    }

    public void setFirstBackPressed(boolean firstBackPressed) {
        this.firstBackPressed = firstBackPressed;
    }

    public boolean isFirstBackPressed() {
        return firstBackPressed;
    }

    /**
     * Handler which resets flag : singleBackPressOccurred
     * times out => when the second BackPress does not occur in the given period of time (doubleBackPress)
     */
    public void resetBackPressFlagHandler() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                firstBackPressed = false;
            }
        }, getDoublePressDuration());
    }

    /**
     * Checks if all required variables have been set
     *
     * @return : true; if all required variables are set (can proceed forward in the application)
     * : throw RequirementsNotMetException; let user know requirements are unfulfilled
     */
    public boolean checkRequiredVariablesSet() {
        if (!verifyRequiredVariablesSet()) {
            throw ErrorsManager.requirementsNotMet(requiredVariablesNotSetMessages());
        }
        // all requirements have been met
        return true;
    }
}