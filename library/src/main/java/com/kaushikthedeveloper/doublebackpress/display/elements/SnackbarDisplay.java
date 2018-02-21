package com.kaushikthedeveloper.doublebackpress.display.elements;


import android.support.design.widget.Snackbar;

import com.kaushikthedeveloper.doublebackpress.display.IntermediateDisplay;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 20-02-2018.
 */
public class SnackbarDisplay implements IntermediateDisplay<Snackbar> {

    @Override
    public void showIntermediateDisplay(Snackbar displayElement) {
        displayElement.show();
    }
}
