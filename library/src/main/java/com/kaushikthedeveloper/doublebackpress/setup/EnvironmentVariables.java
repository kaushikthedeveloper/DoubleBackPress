package com.kaushikthedeveloper.doublebackpress.setup;

import android.content.Context;

import com.kaushikthedeveloper.doublebackpress.helper.Callable;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 22-02-2018.
 *
 * Contains the Required Environment variables involved
 */
public class EnvironmentVariables extends RequirementsConsolidator{
    private Context context;
    private Callable superBackPress;
    private int doublePressDuration;

    public void setContext(Context context) {
        this.context = context;
        contextIsSet();
    }

    public void setDoublePressDuration(int doublePressDuration) {
        this.doublePressDuration = doublePressDuration;
        doublePressDurationIsSet();
    }

    public void setSuperBackPress(Callable superBackPress) {
        this.superBackPress = superBackPress;
        superBackPressedIsSet();
    }

    public Context getContext() {
        return context;
    }

    public int getDoublePressDuration() {
        return doublePressDuration;
    }

    public Callable getSuperBackPress() {
        return superBackPress;
    }
}
