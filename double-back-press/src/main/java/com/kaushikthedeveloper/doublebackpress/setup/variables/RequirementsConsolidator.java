package com.kaushikthedeveloper.doublebackpress.setup.variables;

import com.kaushikthedeveloper.doublebackpress.helper.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 22-02-2018.
 * <p>
 * Keeps track of the status of the environment and required variables
 * : Confirms that the variables are set
 * : Provides error messages
 */
public class RequirementsConsolidator extends OptionalEnvironmentVariables {

    /**
     * @return : true; if the required variables are set
     * : false; if the required variables are not set
     */
    protected boolean verifyRequiredVariablesSet() {
        return !(getDoublePressDuration() == null || getDoubleBackPressAction() == null);
    }

    /**
     * @return : true; if the firstBackPressAction has been set
     * : false; if the firstBackPressAction has not been set
     */
    public boolean verifyFirstBackPressActionSet() {
        return !(getFirstBackPressAction() == null);
    }

    /**
     * Check if the Required
     * Provide a list of Error Messages to be thrown
     *
     * @return List of message
     */
    protected List<String> requiredVariablesNotSetMessages() {
        List<String> messages = new ArrayList<>();
        if (getDoublePressDuration() == null)
            messages.add(Constants.DOUBLE_PRESS_DURATION_NOT_SET);
        if (getDoubleBackPressAction() == null)
            messages.add(Constants.DOUBLE_BACK_PRESS_ACTION_NOT_SET);
        return messages;
    }
}
