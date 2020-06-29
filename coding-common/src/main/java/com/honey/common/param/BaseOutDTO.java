package com.honey.common.param;

import java.io.Serializable;

/**
 * 基础返回类
 */
public class BaseOutDTO implements Serializable{

    /**
     * 返回码
     */
    private String code;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 返回数据实体
     */
    private Object data;

    /**
     * 默认返回成功
     */
    public BaseOutDTO() {
        this(ResponseEnum.SUCCESS);
    }

    public BaseOutDTO(Object data){
        this(ResponseEnum.SUCCESS, data);
    }

    public BaseOutDTO(ResponseEnum em){
        this(em, null);
    }

    public BaseOutDTO(ResponseEnum em, Object data){
        this(em.getCode(), em.getMsg(), data);
    }

    public BaseOutDTO(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
