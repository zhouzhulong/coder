package com.honey.domain.emall.dto.in;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: ZLZHOU
 * @create: 2020-06-19 13:58
 **/
@Data
public class QueryOrderInDTO implements Serializable {

    private String orderId;

    /**
     * 0 联盟 1 kpl
     */
    private Integer type;
}
