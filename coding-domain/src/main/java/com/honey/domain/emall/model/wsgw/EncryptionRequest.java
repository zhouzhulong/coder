package com.honey.domain.emall.model.wsgw;

import lombok.Data;

@Data
public class EncryptionRequest {

    private Object feierData;

    private String sign;

    private Long timestamp;

}
