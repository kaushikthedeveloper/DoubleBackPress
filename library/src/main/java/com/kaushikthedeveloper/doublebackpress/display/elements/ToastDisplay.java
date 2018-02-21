package com.kaushikthedeveloper.doublebackpress.display.elements;

import android.widget.Toast;

import com.kaushikthedeveloper.doublebackpress.display.IntermediateDisplay;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 19-02-2018.
 */
public class ToastDisplay implements IntermediateDisplay<Toast> {
    @Override
    public void showIntermediateDisplay(Toast displayToast) {
        displayToast.show();
    }
}
