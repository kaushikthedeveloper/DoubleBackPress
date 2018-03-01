package com.kaushikthedeveloper.doublebackpress.helper;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 22-02-2018.
 * <p>
 * Holds all static Constant variables
 */
public class Constants {
    private Constants() {
    }

    public static final String DOUBLE_BACK_PRESS_ACTION_NOT_SET = "DOUBLE BACK PRESS ACTION NOT PROVIDED.";
    public static final String DOUBLE_PRESS_DURATION_NOT_SET = "DOUBLE BACK PRESS DURATION NOT PROVIDED.";
    public static final String TOAST_DISPLAY_CONTEXT_NOT_SET = "TOAST_DISPLAY's CONTEXT NOT PROVIDED. Set using .standard(...)";
    public static final String SNACKBAR_DISPLAY_VIEW_NOT_SET = "SNACKBAR_DISPLAY's PARENT VIEW NOT PROVIDED. " +
                                                                "Set using .standard(...)";
    public static final String SNACKBAR_DISPLAY_NPE = "SNACKBAR_DISPLAY SHOULD BE SET AFTER THE VIEW IS CREATED. " +
                                                                "Pls refer to the docs";
}