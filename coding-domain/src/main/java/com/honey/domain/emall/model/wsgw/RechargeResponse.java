package com.honey.domain.emall.model.wsgw;

import lombok.Data;

@Data
public class RechargeResponse {

    private String orderId;

    private String status;

    private String message;

    private String descMsg;
}
