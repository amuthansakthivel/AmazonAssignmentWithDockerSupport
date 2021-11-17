package com.assignment.exceptions;

public class BrowserNotSupportedException extends FrameworkException{

    public BrowserNotSupportedException(String message) {
        super(message);
    }
    public BrowserNotSupportedException(String message, Throwable cause){
        super(message,cause);
    }
}
