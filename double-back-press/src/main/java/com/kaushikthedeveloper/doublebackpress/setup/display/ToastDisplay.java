package com.kaushikthedeveloper.doublebackpress.setup.display;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import com.kaushikthedeveloper.doublebackpress.errors.ErrorsManager;
import com.kaushikthedeveloper.doublebackpress.helper.Constants;
import com.kaushikthedeveloper.doublebackpress.helper.FirstBackPressAction;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 19-02-2018.
 * <p>
 * Toast - standard implementation
 */
public class ToastDisplay implements FirstBackPressAction {
    private Context context;
    private String message;

    /**
     * Constructor : use along with standard() to set the toast to be displayed
     */
    public ToastDisplay() {
    }

    /**
     * Display Toast
     */
    @Override
    public void actionCall() {
        verifyContextIsSet();
        Toast toast = Toast.makeText(this.context, this.message, Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * Ex : new ToastDisplay().standard(this)
     *
     * @param context : application's context
     * @return ToastDisplay : standard settings
     */
    @SuppressLint("ShowToast")
    public ToastDisplay standard(Context context) {
        this.context = context;
        this.message = "Press back button to confirm";
        return this;
    }

    /**
     * Ex : new ToastDisplay().standard(this, "Press back again to exit")
     *
     * @param context : application's context
     * @param message : Message to be displayed in the Toast
     * @return ToastDisplay : standard settings
     */
    @SuppressLint("ShowToast")
    public ToastDisplay standard(Context context, String message) {
        this.context = context;
        this.message = message;
        return this;
    }

    /**
     * Throws RequirementsNotMetException if context is not set
     */
    private void verifyContextIsSet() {
        if (this.context == null) {
            throw ErrorsManager.requirementsNotMet(Constants.TOAST_DISPLAY_CONTEXT_NOT_SET);
        }
    }
}