package com.honey.domain.emall.dto.in;

import lombok.Data;

import java.util.List;

@Data
public class QueryGoodsInDTO {

    private List<Long> skuIds;
}
