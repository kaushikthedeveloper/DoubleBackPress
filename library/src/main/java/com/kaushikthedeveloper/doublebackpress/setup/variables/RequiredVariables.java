package com.kaushikthedeveloper.doublebackpress.setup.variables;

import android.content.Context;

import com.kaushikthedeveloper.doublebackpress.helper.SuperBackPressCallable;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 24-02-2018.
 * <p>
 * REQUIRED Variables : should always be set
 */
class RequiredVariables {
    // application's context
    private Context context = null;
    // application's super.backPressed() function passed using the SuperBackPressCallable
    private SuperBackPressCallable superBackPress = null;
    // timeout duration (msec) : waiting for the Second Back press
    private Integer doublePressDuration = null;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setDoublePressDuration(int doublePressDuration) {
        this.doublePressDuration = doublePressDuration;
    }

    public void setSuperBackPress(SuperBackPressCallable superBackPress) {
        this.superBackPress = superBackPress;
    }

    public Context getContext() {
        return context;
    }

    public Integer getDoublePressDuration() {
        return doublePressDuration;
    }

    public SuperBackPressCallable getSuperBackPress() {
        return superBackPress;
    }
}
