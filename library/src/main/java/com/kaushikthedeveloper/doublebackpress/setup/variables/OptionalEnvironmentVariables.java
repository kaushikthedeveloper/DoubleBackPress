package com.kaushikthedeveloper.doublebackpress.setup.variables;

import com.kaushikthedeveloper.doublebackpress.helper.FirstBackPressAction;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 22-02-2018.
 * <p>
 * Contains the other environment variables involved
 */
class OptionalEnvironmentVariables extends RequiredVariables {
    // actions passed : to be executed after 1st Back press
    private FirstBackPressAction firstBackPressAction = null;

    public void setFirstBackPressAction(FirstBackPressAction firstBackPressAction) {
        this.firstBackPressAction = firstBackPressAction;
    }

    public FirstBackPressAction getFirstBackPressAction() {
        return firstBackPressAction;
    }
}