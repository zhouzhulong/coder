package com.honey.domain.emall.service;

import com.honey.domain.emall.dto.in.QueryGoodsInDTO;
import com.ll.vbox.vboxservice.adapter.service.KeplerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: ZLZHOU
 * @create: 2020-06-19 11:56
 **/
@Service
@Slf4j
public class EmallGoodsService {

    private String kplToken = "9e0fea8b4460488dbb4fb66e396e5875hogi";

    public Object queryJdSku(QueryGoodsInDTO request) throws Exception {
        List<Long> skuIds = request.getSkuIds();
        return KeplerService.getPromotionGoodsinfo("seq", kplToken, skuIds);
    }
}
