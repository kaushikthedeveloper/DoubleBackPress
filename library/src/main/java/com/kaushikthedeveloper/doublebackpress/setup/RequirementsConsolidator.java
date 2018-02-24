package com.kaushikthedeveloper.doublebackpress.setup;

import com.kaushikthedeveloper.doublebackpress.helper.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 22-02-2018.
 * <p>
 * Keeps track of the stauts of the environment variables
 * => Confirms that the required environment variables are set
 */
class RequirementsConsolidator {
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
     * @return : true; all required variables have been set
     *         : false; not all required variables have been set
     */
    boolean requirementsMet() {
        return contextSet && superBackPressSet && doublePressDurationSet;
    }

    /**
     * Provide a list of Error Messages to be thrown
     *
     * @return List<message>
     */
    List<String> unmetRequirementsMessageList() {
        List<String> msg = new ArrayList<>();
        if (!contextSet)
            msg.add(Constants.CONTEXT_NOT_SET);
        if (!superBackPressSet)
            msg.add(Constants.SUPER_BACK_PRESS_NOT_SET);
        if (!doublePressDurationSet)
            msg.add(Constants.DOUBLE_PRESS_DURATION_NOT_SET);

        return msg;
    }
}
