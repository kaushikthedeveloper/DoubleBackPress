package com.kaushikthedeveloper.doublebackpress.setup;

import com.kaushikthedeveloper.doublebackpress.display.IntermediateDisplay;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 22-02-2018.
 * <p>
 * Contains the Environment variables involved
 */
class EnvironmentVariables extends RequiredVariables {
    private IntermediateDisplay intermediateDisplay = null;

    public void setIntermediateDisplay(IntermediateDisplay intermediateDisplay) {
        this.intermediateDisplay = intermediateDisplay;
    }

    public IntermediateDisplay getIntermediateDisplay() {
        return intermediateDisplay;
    }
}
