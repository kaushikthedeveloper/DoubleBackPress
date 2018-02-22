package com.kaushikthedeveloper.doublebackpress.setup;

import com.kaushikthedeveloper.doublebackpress.helper.Constants;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 22-02-2018.
 *
 * Keeps track of the stauts of the environment variables
 * => Confirms that the required environment variables are set
 */
public class RequirementsConsolidator{
    private boolean contextSet;
    private boolean superBackPressSet;
    private boolean doublePressDurationSet;

    void contextIsSet() {
        this.contextSet = true;
    }

    void superBackPressedIsSet() {
        this.superBackPressSet = true;
    }

    void doublePressDurationIsSet() {
        this.doublePressDurationSet = true;
    }

    /**
     * true; all required variables have been set
     * false; not all required variables have been set
     * @return
     */
    boolean requirementsMet(){
        return contextSet && superBackPressSet && doublePressDurationSet;
    }

    String requirementNotMetMsg(){
        String msg = "";
        if(!contextSet)
            msg += Constants.CONTEXT_NOT_SET;
        if(!superBackPressSet)
            msg += Constants.SUPER_BACK_PRESS_NOT_SET;
        if(!doublePressDurationSet)
            msg += Constants.DOUBLE_PRESS_DURAATION_NOT_SET;

        return msg;
    }
}
