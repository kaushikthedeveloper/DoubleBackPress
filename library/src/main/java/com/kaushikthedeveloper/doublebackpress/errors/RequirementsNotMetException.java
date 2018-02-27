package com.kaushikthedeveloper.doublebackpress.errors;

import android.content.res.Resources;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 23-02-2018.
 * <p>
 * Requirements were not met
 */
class RequirementsNotMetException extends Resources.NotFoundException {
    RequirementsNotMetException(String message) {
        super(message);
    }
}
