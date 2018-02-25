package com.kaushikthedeveloper.doublebackpress.setup.display;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.kaushikthedeveloper.doublebackpress.helper.IntermediateDisplay;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 20-02-2018.
 * <p>
 * Snackbar - Intermediate Display
 */
public class SnackbarDisplay implements IntermediateDisplay {
    private Snackbar snackbar;

    /**
     * Constructor : use along with standard() to set the snackbar to be displayed
     */
    public SnackbarDisplay() {
    }

    /**
     * Constructor
     *
     * @param snackbar : Snackbar to be displayed
     */
    public SnackbarDisplay(Snackbar snackbar) {
        this.snackbar = snackbar;
    }

    /**
     * Display Snackbar
     */
    @Override
    public void showIntermediateDisplay() {
        this.snackbar.show();
    }

    /**
     * Ex : new SnackbarDisplay().standard(parentView);
     *
     * @param view : the parentView for the Snackbar
     * @return SnackbarDisplay : Snackbar set to standard display
     */
    public SnackbarDisplay standard(View view) {
        this.snackbar = Snackbar.make(view, "Press back again", Snackbar.LENGTH_SHORT);
        return this;
    }

    /**
     * Ex : new SnackbarDisplay().standard(parentView, "Press back again to exit");
     *
     * @param view    : the parentView for the Snackbar
     * @param message : Message to be displayed in the Snackbar
     * @return SnackbarDisplay : Snackbar set to standard display
     */
    public SnackbarDisplay standard(View view, String message) {
        this.snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        return this;
    }
}