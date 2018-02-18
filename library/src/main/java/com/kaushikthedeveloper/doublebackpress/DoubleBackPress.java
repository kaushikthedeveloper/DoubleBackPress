package com.kaushikthedeveloper.doublebackpress;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

/**
 * Double Back Press operation
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 04-02-2018.
 */
public class DoubleBackPress extends Activity {
    private String intermMessage;
    private int waitDuration;
    private Context context;
    private OverrideSuperBackPressed superBackPressed;

    boolean doubleBackToExitPressedOnce = false;

    /**
     * Constructor
     * @param context : pass Application's context
     * @param intermMessage : message to be shown on 1st back press
     * @param waitDuration : duration of contention for the double back press
     * @param superBackPressed : Application's implementation of Back press
     */
    public DoubleBackPress(Context context, String intermMessage, int waitDuration, OverrideSuperBackPressed superBackPressed) {
        this.context = context;
        this.intermMessage = intermMessage;
        this.waitDuration = waitDuration;
        this.superBackPressed = superBackPressed;
    }

    /**
     * Constructor
     * Should be used as Builder class with the .with... functions
     */
    public DoubleBackPress(){
    }

    /**
     * Builder function for setting context
     * @param context : pass Application's context
     * @return DoubleBackPress
     */
    public DoubleBackPress withContext(Context context){
        this.context = context;
        return this;
    }

    /**
     * Builder function for setting intermediate message
     * @param intermMessage : message to be shown on 1st back press
     * @return DoubleBackPress
     */
    public DoubleBackPress withIntermMsg(String intermMessage){
        this.intermMessage = intermMessage;
        return this;
    }

    /**
     * Builder function for setting the wait duration for the second back press
     * @param waitDuration : duration of contention for the double back press
     * @return DoubleBackPress
     */
    public DoubleBackPress withWaitDuration(int waitDuration){
        this.waitDuration = waitDuration;
        return this;
    }

    /**
     * Builder function for setting the super.backpressed function
     * @param superBackPressed : Application's implementation of Back press
     * @return DoubleBackPress
     */
    public DoubleBackPress withSuperBackPressed(OverrideSuperBackPressed superBackPressed){
        this.superBackPressed = superBackPressed;
        return this;
    }

    /**
     * Overrides the Back press functionality
     */
    @Override
    public void onBackPressed() {
        Log.d("NPK", intermMessage);
        Log.d("NPK", Integer.toString(waitDuration));

        //back pressed
        if (doubleBackToExitPressedOnce) {
            superBackPressed.overriddenSuper();
            return;
        }

        // first back press occurred
        doubleBackToExitPressedOnce = true;

        //Keep Toast Duration to 1sec
        final Toast toast = Toast.makeText(context, intermMessage, Toast.LENGTH_SHORT);
        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 700);

        //Loop to return doubleBackPressed=false
        //If Back pressed with 2s , Exits as doubleBackPressed=false doesn't happen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
