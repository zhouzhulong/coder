package com.honey.domain.emall.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.honey.common.exception.BusinessException;
import com.honey.domain.emall.dao.entity.UserBillDO;
import com.honey.domain.emall.dao.mapper.UserBillMapper;
import com.honey.domain.emall.dto.in.QueryRechargeStatusInDTO;
import com.honey.domain.emall.dto.in.RechargeInDTO;
import com.honey.domain.emall.model.wsgw.*;
import com.ll.vbox.vboxservice.adapter.service.WSGWAdapter;
import com.ll.vbox.vboxservice.adapter.wsgwmodel.WsgwResult;
import com.ll.vbox.vboxservice.adapter.wsgwmodel.WsgwToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

/**
 * @description:
 * @author: ZLZHOU
 * @create: 2020-06-18 16:55
 **/
@Service
@Slf4j
public class EmallRechargeService {

    @Autowired
    private UserBillMapper userBillMapper;

    private String wsgwHost = "https://osg-open.sgcc.com.cn";
    private String rechargePath = "/osg-ep0001/feier/createRecharge";
    private String queryRechargePath = "/osg-ep0001/feier/queryRecharge";
    private String tokenPath = "/oauth2/oauth/token";

    private WsgwToken token;
    public WsgwResult recharge(RechargeInDTO request) throws IOException {
        if(token == null){
         token = WSGWAdapter.getAccessToken(request.getLicense(), wsgwHost + tokenPath);
        }
        log.info("token:{}", JSON.toJSONString(token));
        //直接充值
        String serialNo = UUID.randomUUID().toString().replaceAll("-", "");
        RechargeRequest rechargeRequest = RechargeRequest.builder().bussId(request.getLicense()).license(request.getLicense())
                .sendValue(request.getMoney())
                .serialNo(serialNo)
                .userId(request.getUserId()).build();
        EncryptionRequest encryptionRequest = new EncryptionRequest();
        encryptionRequest.setFeierData(rechargeRequest);
        String resp = WSGWAdapter.invokeBusiRequest(request.getLicense(), wsgwHost + rechargePath, JSON.toJSONString(encryptionRequest), token.getAccess_token(), serialNo);
        EncryptionResponse encryptionResponse = JSON.parseObject(resp, EncryptionResponse.class);
        WsgwResult<RechargeResponse> wsgwResult = JSON.parseObject(JSON.toJSONString(encryptionResponse.getFeierData()), WsgwResult.class);
        if ("0".equals(wsgwResult.getCode())) {
            RechargeResponse response = JSON.parseObject(JSON.toJSONString(wsgwResult.getData()), RechargeResponse.class);
            String orderId = response.getOrderId();
            UserBillDO userBillDO = new UserBillDO();
            userBillDO.setUserId(request.getUserId());
            userBillDO.setBillId(request.getLicense());
            userBillDO.setType("5");
            userBillDO.setTelno("");
            userBillDO.setOrderId(orderId);
            userBillDO.setMoney(Double.valueOf(request.getMoney()));
            userBillDO.setStatus("2");
            userBillDO.setDesc("手动充值");
            userBillMapper.insert(userBillDO);
        }
        return wsgwResult;
    }

    public WsgwResult queryRecharge(QueryRechargeStatusInDTO request) throws IOException {
        QueryWrapper<UserBillDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("bill_id", request.getBizId());
        UserBillDO userBillDO = userBillMapper.selectOne(queryWrapper);
        if (userBillDO == null) {
            throw new BusinessException();
        }
        WsgwToken token = WSGWAdapter.getAccessToken(request.getBizId(), wsgwHost + tokenPath);
        log.info("token:{}", JSON.toJSONString(token));
        QueryRechargeRequest queryRechargeRequest = new QueryRechargeRequest();
        queryRechargeRequest.setBussId(request.getBizId());
        EncryptionRequest encryptionRequest = new EncryptionRequest();
        encryptionRequest.setFeierData(queryRechargeRequest);
        String resp = WSGWAdapter.invokeBusiRequest(request.getBizId(), wsgwHost + queryRechargePath, JSON.toJSONString(encryptionRequest), token.getAccess_token(), request.getBizId());
        EncryptionResponse encryptionResponse = JSON.parseObject(resp, EncryptionResponse.class);
        WsgwResult<RechargeResponse> wsgwResult = JSON.parseObject(JSON.toJSONString(encryptionResponse.getFeierData()), WsgwResult.class);
        if ("0".equals(wsgwResult.getCode())) {
            RechargeResponse response = JSON.parseObject(JSON.toJSONString(wsgwResult.getData()), RechargeResponse.class);
            if (response.getStatus().equals("03")) {
                userBillDO.setStatus("1");
                userBillMapper.updateById(userBillDO);
            }
        }
        return wsgwResult;
    }
}
