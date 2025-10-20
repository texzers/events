package com.event.ErrorClass;

public class InvalidUserId extends RuntimeException {
    public InvalidUserId(String msg) {
        super(msg);
    }
}
