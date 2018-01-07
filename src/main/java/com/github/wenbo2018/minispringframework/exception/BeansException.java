package com.github.wenbo2018.minispringframework.exception;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public class BeansException  extends RuntimeException{

    public BeansException() {
        super();
    }

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeansException(Throwable cause) {
        super(cause);
    }

    protected BeansException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
