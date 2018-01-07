package com.github.wenbo2018.minispringframework.exception;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public class BeanDefinitionStoreException extends RuntimeException {

    public BeanDefinitionStoreException() {
        super();
    }

    public BeanDefinitionStoreException(String message) {
        super(message);
    }

    public BeanDefinitionStoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanDefinitionStoreException(Throwable cause) {
        super(cause);
    }

    protected BeanDefinitionStoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
