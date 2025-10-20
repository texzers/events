package com.event.ErrorClass;

public class UserAlreadyExist extends RuntimeException{
    public UserAlreadyExist(String msg){
        super(msg);
    }
}
