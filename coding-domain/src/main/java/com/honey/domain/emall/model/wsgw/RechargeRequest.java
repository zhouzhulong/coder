package com.honey.domain.emall.model.wsgw;

import com.alibaba.fastjson.JSON;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class RechargeRequest implements Serializable {

    private static final long serialVersionUID = -2526626024873335442L;

    private String bussId;

    private String serialNo;

    private String userId;

    private String license;

    private Integer sendValue;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
