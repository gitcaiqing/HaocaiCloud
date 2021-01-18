package com.haocai.order.service.impl;

import com.haocai.base.cloudbase.entity.SecondKillOrder;
import com.haocai.base.cloudbase.mapper.SecondKillOrderMapper;
import com.haocai.order.service.SecondKillOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class SecondKillOrderServiceImpl implements SecondKillOrderService {

    @Autowired
    private SecondKillOrderMapper secondKillOrderMapper;

    @Override
    public SecondKillOrder create(Long goodsId, String name, Long phone) {
        try {
            SecondKillOrder secondKillOrder = new SecondKillOrder();
            secondKillOrder.setGoodsId(goodsId);
            secondKillOrder.setPlaceName(name);
            secondKillOrder.setPlacePhone(phone);
            Date date = new Date();
            secondKillOrder.setCreatedTime(date);
            secondKillOrder.setUpdatedTime(date);
            secondKillOrder.setVersion(0);
            secondKillOrderMapper.insertSelective(secondKillOrder);
            return secondKillOrder;
        } catch (Exception e) {
            log.error("创建订单失败：{}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
