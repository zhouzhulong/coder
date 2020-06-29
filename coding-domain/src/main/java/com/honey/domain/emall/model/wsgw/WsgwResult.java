package com.honey.domain.emall.model.wsgw;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: ZLZHOU
 * @create: 2020-04-08 17:30
 **/


@Data
public class WsgwResult<T> implements Serializable {

    protected String code;

    protected String message;

    protected T data;

    private boolean success;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }


}
