package com.kaushikthedeveloper.doublebackpress.errors;

import java.util.List;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 23-02-2018.
 * <p>
 * Error handling module designed to throw errors at appropriate times
 */
public class ErrorsManager extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ErrorsManager(String message) {
        super(message);
    }

    /**
     * Append the Error messages
     *
     * @param messages : List of messages
     * @return errorMessageString
     */
    private static String getErrorMessagesString(List<String> messages) {
        String errorMessageString = "";
        for (String msg : messages) {
            errorMessageString = errorMessageString.concat(msg + "\n");
        }
        return errorMessageString;
    }

    /**
     * @param messages : List of messages
     * throw RequirementsNotMetException
     */
    public static RequirementsNotMetException requirementsNotMet(List<String> messages) {
        throw new RequirementsNotMetException(getErrorMessagesString(messages));
    }

    /**
     * @param message : Error message
     * throw RequirementsNotMetException
     */
    public static RequirementsNotMetException requirementsNotMet(String message) {
        throw new RequirementsNotMetException(message);
    }

    /**
     * @param messages : List of messages
     * throw GeneralException
     */
    public static GeneralException generalException(List<String> messages){
        throw new GeneralException(getErrorMessagesString(messages));
    }

    /**
     * @param message : Error message
     * throw GeneralException
     */
    public static GeneralException generalException(String message){
        throw new GeneralException(message);
    }
}
