package com.kaushikthedeveloper.doublebackpress.setup;

import com.kaushikthedeveloper.doublebackpress.helper.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 22-02-2018.
 * <p>
 * Keeps track of the status of the environment and required variables
 * => Confirms that the variables are set
 * => Provides error messages
 */
class RequirementsConsolidator extends EnvironmentVariables {

    /**
     * @return : true; if the required variables are set
     * : false; if the required variables are not set
     */
    boolean verifyRequiredVariablesSet() {
        return !(getContext() == null || getDoublePressDuration() == null || getSuperBackPress() == null);
    }

    /**
     * Check if the Required
     * Provide a list of Error Messages to be thrown
     *
     * @return List<message>
     */
    List<String> requiredVariablesNotSetMessages() {
        List<String> messages = new ArrayList<>();
        if (getContext() == null)
            messages.add(Constants.CONTEXT_NOT_SET);
        if (getDoublePressDuration() == null)
            messages.add(Constants.DOUBLE_PRESS_DURATION_NOT_SET);
        if (getSuperBackPress() == null)
            messages.add(Constants.SUPER_BACK_PRESS_NOT_SET);
        return messages;
    }
}
