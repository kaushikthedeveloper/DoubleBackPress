package com.kaushikthedeveloper.doublebackpress.setup.errors;

import android.content.res.Resources;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 23-02-2018.
 * <p>
 * Requirements were not met
 */
public class RequirementsNotMetException extends Resources.NotFoundException {
    public RequirementsNotMetException(String message) {
        super(message);
    }
}
