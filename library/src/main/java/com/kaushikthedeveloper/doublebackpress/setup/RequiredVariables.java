package com.kaushikthedeveloper.doublebackpress.setup;

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
    // timeout duration : waiting for the Second Back press
    private Integer doublePressDuration = null;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setDoublePressDuration(int doublePressDuration) {
        this.doublePressDuration = doublePressDuration;
    }

    public void setSuperBackPress(Callable superBackPress) {
        this.superBackPress = superBackPress;
    }

    Context getContext() {
        return context;
    }

    Integer getDoublePressDuration() {
        return doublePressDuration;
    }

    public Callable getSuperBackPress() {
        return superBackPress;
    }
}
