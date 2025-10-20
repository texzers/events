package com.event.EventController;

import com.event.ErrorClass.InvalidUserId;
import com.event.ErrorClass.NotFoundException;
import com.event.ErrorClass.UserAlreadyExist;
import com.event.EventsPojo.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.IOException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity FileNotFound(NotFoundException Nt){

        Error er = new Error(Nt.getMessage(), 400, System.currentTimeMillis());
        return ResponseEntity.status(400).body(er);
    }

    @ExceptionHandler(UserAlreadyExist.class)
    public ResponseEntity UserNotFound(UserAlreadyExist Ue)
    {
        Error er = new Error(Ue.getMessage(),409, System.currentTimeMillis());
        return ResponseEntity.status(409).body(er);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity MethodArgumentMismatch(MethodArgumentTypeMismatchException Me){
        Error er = new Error(Me.getMessage(),500, System.currentTimeMillis());
        return ResponseEntity.status(500).body(er);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgInvalid(MethodArgumentNotValidException Me){
        Error er = new Error(Me.getMessage(), 500, System.currentTimeMillis());
        return ResponseEntity.status(500).body(er);
    }

    @ExceptionHandler(InvalidUserId.class)
    public ResponseEntity InvalidUserId(InvalidUserId invalidUserId){
        Error er = new Error(invalidUserId.getMessage(),401, System.currentTimeMillis());
        return ResponseEntity.status(401).body(er);
    }
}
