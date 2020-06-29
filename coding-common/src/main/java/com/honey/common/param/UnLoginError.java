package com.honey.common.param;

/**
 * @author liyong
 * @version 1.0
 * @date 2020/5/19 10:37
 */
public class UnLoginError extends RuntimeException{
    public UnLoginError() {
    }

    public UnLoginError(String message) {
        super(message);
    }

    public UnLoginError(ResponseEnum em) {
        super(em.getMsg());
    }
}
