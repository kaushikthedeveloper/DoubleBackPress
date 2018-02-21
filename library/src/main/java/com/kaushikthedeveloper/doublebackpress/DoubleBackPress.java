package com.kaushikthedeveloper.doublebackpress;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.kaushikthedeveloper.doublebackpress.helper.Callable;

/**
 * Double Back Press operation
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 04-02-2018.
 */
public class DoubleBackPress extends Activity {
    private Context context;
    private String intermMessage;
    private Callable superBackPressed;
    private int waitDuration;

    private boolean singleBackPressDone;

    /**
     * Constructor
     * @param context : pass Application's context
     * @param intermMessage : message to be shown on 1st back press
     * @param waitDuration : duration of contention for the double back press (msec)
     * @param superBackPressed : Application's implementation of Back press
     */
    public DoubleBackPress(Context context, String intermMessage, int waitDuration, Callable superBackPressed) {
        this.context = context;
        this.intermMessage = intermMessage;
        this.waitDuration = waitDuration;
        this.superBackPressed = superBackPressed;
        this.singleBackPressDone = false;
    }

    /**
     * Constructor
     * Should be used as Builder class with the .with... functions
     */
    public DoubleBackPress(){
        this.singleBackPressDone = false;
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
     * Builder function for setting the super.backpressed function
     * @param superBackPressed : Application's implementation of Back press
     * @return DoubleBackPress
     */
    public DoubleBackPress withSuperBackPressed(Callable superBackPressed){
        this.superBackPressed = superBackPressed;
        return this;
    }

    /**
     * Builder function for setting the wait duration for the second back press (msec)
     * @param waitDuration : duration of contention for the double back press
     * @return DoubleBackPress
     */
    public DoubleBackPress withWaitDuration(int waitDuration){
        this.waitDuration = waitDuration;
        return this;
    }

    /**
     * Overrides the Back press functionality
     */
    @Override
    public void onBackPressed() {
        // second back press
        if (singleBackPressDone) {
            superBackPressed.callableFunction();
            return;
        }

        // first back press occurred
        singleBackPressDone = true;

        // toast on first back press
        Toast.makeText(context, intermMessage, Toast.LENGTH_SHORT).show();

        // loop to return doubleBackPressed = false ; when time expires but no second back press
        // if Back pressed with waitDuration , calls the super method
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                singleBackPressDone = false;
            }
        }, waitDuration);
    }
}
