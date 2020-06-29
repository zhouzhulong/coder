package com.honey.domain.emall.model.wsgw;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

@Data
public class QueryRechargeRequest implements Serializable {

    private static final long serialVersionUID = -8436301746677770161L;

    private String bussId;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
