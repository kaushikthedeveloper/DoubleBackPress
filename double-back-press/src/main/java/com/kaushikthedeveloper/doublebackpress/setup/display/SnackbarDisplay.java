package com.kaushikthedeveloper.doublebackpress.setup.display;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.kaushikthedeveloper.doublebackpress.errors.ErrorsManager;
import com.kaushikthedeveloper.doublebackpress.helper.Constants;
import com.kaushikthedeveloper.doublebackpress.helper.FirstBackPressAction;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 20-02-2018.
 * <p>
 * Snackbar - Standard i
 */
public class SnackbarDisplay extends Activity implements FirstBackPressAction {
    private View parentView;
    private String message;
    private boolean standardFunctionCalled = false;

    /**
     * Constructor : use along with standard() to set the snackbar to be displayed
     */
    public SnackbarDisplay() {
    }

    /**
     * Display Snackbar
     */
    @Override
    public void actionCall() {
        verifyViewIsSet();
        Snackbar snackbar = Snackbar.make(this.parentView, this.message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    /**
     * Ex : new SnackbarDisplay().standard(parentView);
     *
     * @param view : the parentView for the Snackbar
     * @return SnackbarDisplay : standard settings
     */
    public SnackbarDisplay standard(View view) {
        this.parentView = view;
        this.message = "Press back button to confirm";
        this.standardFunctionCalled = true;
        return this;
    }

    /**
     * Ex : new SnackbarDisplay().standard(parentView, "Press back again to exit");
     *
     * @param view    : the parentView for the Snackbar
     * @param message : Message to be displayed in the Snackbar
     * @return SnackbarDisplay : standard settings
     */
    public SnackbarDisplay standard(View view, String message) {
        this.parentView = view;
        this.message = message;
        this.standardFunctionCalled = true;
        return this;
    }

    /**
     * Throws RequirementsNotMetException if parentView is not set
     */
    private void verifyViewIsSet() {
        if(!this.standardFunctionCalled){
            throw ErrorsManager.requirementsNotMet(Constants.SNACKBAR_DISPLAY_VIEW_NOT_SET);
        }
        if (this.parentView == null) {
            throw ErrorsManager.requirementsNotMet(Constants.SNACKBAR_DISPLAY_NPE);
        }
    }
}