package com.kaushikthedeveloper.doublebackpress;

import android.os.Handler;

import com.kaushikthedeveloper.doublebackpress.errors.ErrorsManager;
import com.kaushikthedeveloper.doublebackpress.setup.variables.RequirementsConsolidator;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 21-02-2018.
 * <p>
 * Manage the state of the DoubleBackPress module
 */
class FlowManager extends RequirementsConsolidator {
    private boolean firstBackPressed;

    /**
     * At the start, no Back press has occurred
     */
    FlowManager() {
        firstBackPressed = false;
    }

    void setFirstBackPressed(boolean firstBackPressed) {
        this.firstBackPressed = firstBackPressed;
    }

    boolean isFirstBackPressed() {
        return firstBackPressed;
    }

    /**
     * Handler which resets flag : singleBackPressOccurred
     * times out => when the second BackPress does not occur in the given period of time (doubleBackPress)
     */
    void resetBackPressFlagHandler() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                firstBackPressed = false;
            }
        }, getDoublePressDuration());
    }

    /**
     * Checks if all required variables have been set
     * let user know requirements are unfulfilled
     *
     * => throw RequirementsNotMetException; when required variable has not been set
     */
    void checkRequiredVariablesSet() {
        if (!verifyRequiredVariablesSet()) {
            throw ErrorsManager.requirementsNotMet(requiredVariablesNotSetMessages());
        }
    }
}