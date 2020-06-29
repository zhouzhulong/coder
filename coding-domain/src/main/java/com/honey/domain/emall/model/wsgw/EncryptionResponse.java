package com.honey.domain.emall.model.wsgw;

import lombok.Data;

@Data
public class EncryptionResponse<T> {

    private T feierData;

    private Long timestamp;
}
