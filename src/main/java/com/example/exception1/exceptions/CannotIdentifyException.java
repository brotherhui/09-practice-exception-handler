package com.example.exception1.exceptions;

import com.example.exception1.ErrorCode;

/**
 * Created on 02.03.17.
 */
public class CannotIdentifyException extends RuntimeException implements ApplicationException{
    private final ErrorCode code;

    public CannotIdentifyException(ErrorCode code) {
        this.code = code;
    }

    @Override
    public ErrorCode getErrorCode() {
        return this.code;
    }
}
