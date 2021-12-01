package com.hengheng.util.omp4j.exceptions;

/**
 * @author panhb
 */
public class OmpUtilsException extends Exception {

    private Throwable cause = null;

    public OmpUtilsException(String s) {
        super(s);
    }

    public OmpUtilsException(String s, Throwable e) {
        super(s);
        this.cause = e;
    }

    @Override
    public Throwable getCause() {
        return this.cause;
    }

}
