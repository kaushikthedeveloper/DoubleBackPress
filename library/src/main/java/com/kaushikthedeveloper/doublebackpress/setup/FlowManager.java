package com.kaushikthedeveloper.doublebackpress.setup;

import android.os.Handler;

import com.kaushikthedeveloper.doublebackpress.setup.errors.ErrorsManager;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 21-02-2018.
 * <p>
 * Manage the state of the DoubleBackPress module
 */
class FlowManager extends EnvironmentVariables {
    private boolean firstBackPressed;

    /**
     * At the start, no Back press has occurred
     */
    FlowManager() {
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
     * => when the second BackPress does not occur in the given period of time
     */
    private void resetBackPressFlagHandler() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                firstBackPressed = false;
            }
        }, getDoublePressDuration());
    }

    /**
     * Checks if all requirements have been met
     * If met => true; proceed forward
     * else => throw Exception; let user know requirements are unfulfilled
     *
     * @return boolean
     */
    public boolean checkRequirementsFulfilled() {
        if (!requirementsMet()) {
            throw ErrorsManager.requirementsNotMet(unmetRequirementsMessageList());
        }
        // all requirements have been met
        return true;
    }
}