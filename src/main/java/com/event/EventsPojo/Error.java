package com.event.EventsPojo;

import java.time.LocalDateTime;

public class Error {
    private String message;
    private int statuscode;
    private long localDateTime;

    public Error(String message, int statuscode, long localDateTime) {
        this.message = message;
        this.statuscode = statuscode;
        this.localDateTime = localDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public long getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(long localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Error() {

    }


}
