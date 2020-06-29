package com.honey.domain.emall.controller;

import com.honey.common.param.BaseOutDTO;
import com.honey.domain.emall.service.EmallRechargeService;
import com.honey.domain.emall.dto.in.QueryRechargeStatusInDTO;
import com.honey.domain.emall.dto.in.RechargeInDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @description:
 * @author: ZLZHOU
 * @create: 2020-06-18 16:45
 **/
@Slf4j
@RequestMapping("recharge")
@RestController
public class EmallRechargeController {

    @Autowired
    private EmallRechargeService rechargeService;

    @PostMapping("/dorecharge")
    public BaseOutDTO recharge(@RequestBody RechargeInDTO request) throws IOException {
        return new BaseOutDTO(rechargeService.recharge(request));
    }

    @PostMapping("/queryRechargeStatus")
    public BaseOutDTO recharge(@RequestBody QueryRechargeStatusInDTO request) throws IOException {
        return new BaseOutDTO(rechargeService.queryRecharge(request));
    }
}
