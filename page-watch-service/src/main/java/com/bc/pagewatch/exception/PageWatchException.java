package com.bc.pagewatch.exception;

public class PageWatchException extends RuntimeException {

    public PageWatchException(String message) {
        super(message);
    }

    public PageWatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
