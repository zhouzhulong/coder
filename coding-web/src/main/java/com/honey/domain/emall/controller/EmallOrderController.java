package com.honey.domain.emall.controller;

import com.honey.common.param.BaseOutDTO;
import com.honey.domain.emall.dto.in.QueryOrderInDTO;
import com.honey.domain.emall.service.EmallOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @description:
 * @author: ZLZHOU
 * @create: 2020-06-19 13:57
 **/
@RequestMapping("order")
@RestController
public class EmallOrderController {

    @Autowired
    private EmallOrderService orderService;

    @PostMapping("/queryOrder")
    public BaseOutDTO recharge(@RequestBody QueryOrderInDTO request) throws IOException {
        return new BaseOutDTO(orderService.queryOrder(request));
    }
}
