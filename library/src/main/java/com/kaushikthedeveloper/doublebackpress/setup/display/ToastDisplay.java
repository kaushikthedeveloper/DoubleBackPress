package com.kaushikthedeveloper.doublebackpress.setup.display;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import com.kaushikthedeveloper.doublebackpress.helper.IntermediateDisplay;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 19-02-2018.
 * <p>
 * Toast - Intermediate Display
 */
public class ToastDisplay implements IntermediateDisplay {
    private Toast toast;

    /**
     * Constructor : use along with standard() to set the toast to be displayed
     */
    public ToastDisplay() {
    }

    /**
     * Constructor
     * @param toast : Toast to be displayed
     */
    public ToastDisplay(Toast toast) {
        this.toast = toast;
    }

    /**
     * Display Toast
     */
    @Override
    public void showIntermediateDisplay() {
        this.toast.show();
    }

    /**
     * Ex : new ToastDisplay().standard(this)
     *
     * @param context : application's context
     * @return ToastDisplay : toast set to standard settings
     */
    @SuppressLint("ShowToast")
    public ToastDisplay standard(Context context) {
        this.toast = Toast.makeText(context, "Press back again", Toast.LENGTH_SHORT);
        return this;
    }

    /**
     * Ex : new ToastDisplay().standard(this, "Press back again to exit")
     *
     * @param context : application's context
     * @param message : Message to be displayed in the Toast
     * @return ToastDisplay : toast set to standard settings
     */
    @SuppressLint("ShowToast")
    public ToastDisplay standard(Context context, String message){
        this.toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        return this;
    }
}