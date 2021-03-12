package com.haocai.order.service.impl;

import com.haocai.base.cloudbase.entity.SecondKillOrder;
import com.haocai.base.cloudbase.mapper.SecondKillOrderMapper;
import com.haocai.base.cloudbase.vo.SecondKillVO;
import com.haocai.order.service.SecondKillGoodsService;
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

    @Autowired
    private SecondKillGoodsService secondKillGoodsService;

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

    /**
     * 消费kafka消息创建订单， 同时更新数据库中的库存和redis中的库存信息
     * @param goodsId
     * @param name
     * @param phone
     * @return
     */
    @Override
    public SecondKillOrder consumerTopicToCreateOrderWithKafka(Long goodsId, String name, Long phone) {
        //更新数据库中的库存

        //更新redis中的库存

        //创建订单

        return null;
    }
}
