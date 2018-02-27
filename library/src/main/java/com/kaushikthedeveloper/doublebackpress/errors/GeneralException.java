package com.kaushikthedeveloper.doublebackpress.errors;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 27-02-2018.
 *
 * General Exceptions explicitly expected in the library
 */
public class GeneralException extends RuntimeException {
    public GeneralException(String message) {
        super(message);
    }
}
