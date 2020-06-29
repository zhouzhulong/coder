package com.honey.domain.emall.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.honey.domain.emall.dao.entity.OrderInfoDO;
import com.honey.domain.emall.dao.mapper.OrderInfoMapper;
import com.honey.domain.emall.dto.in.QueryOrderInDTO;
import com.honey.domain.emall.enums.EmallOrderTypeEnum;
import com.google.common.collect.Lists;
import com.ll.vbox.vboxservice.adapter.keplermodel.PullNormalOrderListResponse;
import com.ll.vbox.vboxservice.adapter.keplermodel.PullOrderListResponse;
import com.ll.vbox.vboxservice.adapter.service.KeplerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: ZLZHOU
 * @create: 2020-06-19 11:56
 **/
@Service
@Slf4j
public class EmallOrderService {

    private SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
    private Long hour = 60 * 60 * 1000L;
    private String kplToken = "9e0fea8b4460488dbb4fb66e396e5875hogi";

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    public Object queryOrder(QueryOrderInDTO request) {
        String orderId = request.getOrderId();
        if (request.getType() != null && request.getType().equals(EmallOrderTypeEnum.KEPLER.getType())) {
            PullNormalOrderListResponse pullOrderListResponse = KeplerService.pullNormalOrderList(orderId, kplToken, orderId, "20200217000000", "20200217000000", "1", "1", true);
            if (pullOrderListResponse != null && StringUtils.isBlank(pullOrderListResponse.getErrorMsg())) {
                List<PullNormalOrderListResponse.OrdersEntity> ordersEntities = pullOrderListResponse.getOrders();
                if (CollectionUtils.isNotEmpty(ordersEntities)) {
                    return ordersEntities.get(0);
                }
            }
        }
        QueryWrapper<OrderInfoDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", orderId);
        OrderInfoDO orderInfoDO = orderInfoMapper.selectOne(queryWrapper);
        List<String> kplOrdertime = genKplInTime(orderInfoDO.getOrderTime());
        List<PullOrderListResponse.ResultEntity> orderList = Lists.newArrayList();
        int pageCount = 50;
        for (String orderTime : kplOrdertime) {
            boolean hasNext = true;
            for (int startIndex = 1; hasNext; startIndex++) {
                PullOrderListResponse pullOrderListResponse = KeplerService.pullOrderList(orderId, kplToken, "1", orderTime, startIndex + "", String.valueOf(pageCount), true);
                if (pullOrderListResponse != null && StringUtils.isBlank(pullOrderListResponse.getErrorMsg())) {
                    List<PullOrderListResponse.ResultEntity> result = pullOrderListResponse.getResult();
                    if (null != result) {
                        orderList.addAll(result);
                    }
                    hasNext = pullOrderListResponse.isHasNext();
                }
            }
        }
        for (PullOrderListResponse.ResultEntity resultEntity : orderList) {
            if (resultEntity.getOrderId() == Long.parseLong(orderId)) {
                return resultEntity;
            }
        }
        return null;
    }

    private List<String> genKplInTime(LocalDateTime time) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = time.atZone(zone).toInstant();
        long startIndex = instant.toEpochMilli() - 6 * hour;
        long endIndex = instant.toEpochMilli() + 6 * hour;
        List<String> times = Lists.newArrayList();
        for (; startIndex <= endIndex; startIndex += hour) {
            Date d = new Date(startIndex);
            times.add(format.format(d));
        }
        return times;
    }
}
