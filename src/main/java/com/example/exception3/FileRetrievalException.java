package com.example.exception3;

public class FileRetrievalException extends RuntimeException {

    public FileRetrievalException() {
    }

    public FileRetrievalException(String message) {
        super(message);
    }

    public FileRetrievalException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileRetrievalException(Throwable cause) {
        super(cause);
    }
}
