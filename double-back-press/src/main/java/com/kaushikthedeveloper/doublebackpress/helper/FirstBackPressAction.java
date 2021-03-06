package com.kaushikthedeveloper.doublebackpress.helper;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 19-02-2018.
 * <p>
 * Interface used for displaying message after the first back press : Toast, Snackbar
 * <p>
 * Can be used by the User to provide custom actions
 */
public interface FirstBackPressAction {
    void actionCall();
}