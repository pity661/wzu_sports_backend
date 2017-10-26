package com.wzsport.exception;

/**
 * Created by kouga on 2017/8/19.
 */
public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException() {
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
