package com.honey.domain.emall.controller;

import com.honey.common.param.BaseOutDTO;
import com.honey.domain.emall.dto.in.QueryGoodsInDTO;
import com.honey.domain.emall.service.EmallGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: ZLZHOU
 * @create: 2020-06-19 13:57
 **/
@RequestMapping("goods")
@RestController
public class EmallGoodsController {

    @Autowired
    private EmallGoodsService goodsService;

    @PostMapping("/queryJdSku")
    public BaseOutDTO queryJdSku(@RequestBody QueryGoodsInDTO request) throws Exception {
        return new BaseOutDTO(goodsService.queryJdSku(request));
    }
}

