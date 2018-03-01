package com.kaushikthedeveloper.doublebackpress.setup.variables;

import com.kaushikthedeveloper.doublebackpress.helper.DoubleBackPressAction;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 24-02-2018.
 * <p>
 * REQUIRED Environment Variables : should always be set
 */
class RequiredVariables {
    // actions passed : to be executed after DoubleBackPress
    private DoubleBackPressAction doubleBackPressAction = null;
    // timeout duration (msec) : waiting for the Second Back press
    private Integer doublePressDuration = null;

    public void setDoublePressDuration(int doublePressDuration) {
        this.doublePressDuration = doublePressDuration;
    }

    public void setDoubleBackPressAction(DoubleBackPressAction doubleBackPressAction) {
        this.doubleBackPressAction = doubleBackPressAction;
    }

    protected Integer getDoublePressDuration() {
        return doublePressDuration;
    }

    public DoubleBackPressAction getDoubleBackPressAction() {
        return doubleBackPressAction;
    }
}
