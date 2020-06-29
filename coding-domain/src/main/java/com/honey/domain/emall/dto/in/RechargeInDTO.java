package com.honey.domain.emall.dto.in;

import lombok.Data;

/**
 * @description:
 * @author: ZLZHOU
 * @create: 2020-06-18 18:23
 **/
@Data
public class RechargeInDTO {

    private String userId;

    private String license;

    private Integer money;
}
