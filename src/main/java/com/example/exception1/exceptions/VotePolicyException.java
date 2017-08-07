package com.example.exception1.exceptions;

import com.example.exception1.ErrorCode;

/**
 *
 * Created on 18.02.17.
 */
public class VotePolicyException extends RuntimeException implements ApplicationException {
    private final ErrorCode code;

    public VotePolicyException(ErrorCode code) {
        this.code = code;
    }

    @Override
    public ErrorCode getErrorCode() {
        return code;
    }
}
