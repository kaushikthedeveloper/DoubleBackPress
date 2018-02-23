package com.kaushikthedeveloper.doublebackpress.setup.errors;

import java.util.List;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 23-02-2018.
 * <p>
 * Error handling module designed to throw errors at appropriate times
 */
public class ErrorsManager extends RuntimeException {

    public ErrorsManager(String message) {
        super(message);
    }

    /**
     * Append the Error messages
     *
     * @param messages : List<message>
     * @return errorMessage
     */
    public static String getErrorMessage(List<String> messages) {
        String errorMessage = "";
        for (String msg : messages) {
            errorMessage = errorMessage.concat(msg + "\n");
        }
        return errorMessage;
    }

    /**
     * throw Error of type : RequirementsNotMetException
     *
     * @param messages : List<message>
     * @return throw RequirementsNotMetException
     */
    public static RequirementsNotMetException requirementsNotMet(List<String> messages) {
        throw new RequirementsNotMetException(getErrorMessage(messages));
    }
}
