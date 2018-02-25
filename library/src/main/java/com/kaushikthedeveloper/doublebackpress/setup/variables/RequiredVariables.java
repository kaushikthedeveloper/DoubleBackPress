package com.kaushikthedeveloper.doublebackpress.setup.variables;

import android.content.Context;

import com.kaushikthedeveloper.doublebackpress.helper.Callable;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 24-02-2018.
 * <p>
 * REQUIRED Variables : should always be set
 */
class RequiredVariables {
    // application's context
    private Context context = null;
    // application's super.backPressed() function passed using the Callable
    private Callable superBackPress = null;
    // timeout duration (msec) : waiting for the Second Back press
    private Integer doublePressDuration = null;

    protected void setContext(Context context) {
        this.context = context;
    }

    protected void setDoublePressDuration(int doublePressDuration) {
        this.doublePressDuration = doublePressDuration;
    }

    protected void setSuperBackPress(Callable superBackPress) {
        this.superBackPress = superBackPress;
    }

    Context getContext() {
        return context;
    }

    protected Integer getDoublePressDuration() {
        return doublePressDuration;
    }

    public Callable getSuperBackPress() {
        return superBackPress;
    }
}
