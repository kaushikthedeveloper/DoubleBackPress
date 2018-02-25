package com.kaushikthedeveloper.doublebackpress.setup.variables;

import com.kaushikthedeveloper.doublebackpress.helper.IntermediateDisplay;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 22-02-2018.
 * <p>
 * Contains the other environment variables involved
 */
class OptionalEnvironmentVariables extends RequiredVariables {
    // Intermediate display : shown after first back press
    IntermediateDisplay intermediateDisplay = null;

    public void setIntermediateDisplay(IntermediateDisplay intermediateDisplay) {
        this.intermediateDisplay = intermediateDisplay;
    }

    public IntermediateDisplay getIntermediateDisplay() {
        return intermediateDisplay;
    }
}