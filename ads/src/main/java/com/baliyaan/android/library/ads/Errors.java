package com.baliyaan.android.library.ads;

/**
 * Created by Pulkit Singh on 11/4/2017.
 */

public class Errors {

    public static class AdException extends Exception {
        public AdException(String message) {
            super(message);
        }
    }
}
