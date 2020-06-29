package com.honey.common.exception;


import com.honey.common.param.ResponseEnum;

/**
 * 处理业务异常
 * @author liyong
 * @version 1.0
 * @date 2020/3/26 11:21
 */
public class BusinessException extends RuntimeException{

    public BusinessException(){}

    public BusinessException(String message){
        super(message);
    }


    public BusinessException(ResponseEnum en){
        super(en.getMsg());
    }
}
