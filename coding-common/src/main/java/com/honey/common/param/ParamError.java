package com.honey.common.param;

public class ParamError extends RuntimeException {

    public ParamError() {
    }

    public ParamError(String message) {
        super(message);
    }
}
