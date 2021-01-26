package com.haocai.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.haocai.base.cloudbase.entity.SecondKillOrder;
import com.haocai.base.cloudbase.enums.TopicEnum;
import com.haocai.base.cloudbase.exception.BusinessException;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.base.cloudbase.vo.SecondKillVO;
import com.haocai.order.service.SecondKillGoodsService;
import com.haocai.order.service.SecondKillOrderService;
import com.haocai.order.service.SecondKillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class SecondKillServiceImpl implements SecondKillService {

    @Autowired
    private SecondKillGoodsService secondKillGoodsService;

    @Autowired
    private SecondKillOrderService secondKillOrderService;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 下单人进行下单操作
     * @param goodsId 商品id
     * @param name 下单人名称
     * @param phone 下单人电话
     * @return
     */
    @Override
    @Transactional
    public ResponseMessage placeCreateOrder(Long goodsId, String name, Long phone) {

        try {
            //预扣减库存: 默认1人只能抢购1个商品,当库存不够时 下单失败
            if(!secondKillGoodsService.reduceStock(goodsId, 1)){
                return ResponseMessage.error("抢购失败");
            }

            //方案1：直接创建订单
            //注：下单失败则回滚扣减的库存1
            SecondKillOrder order = secondKillOrderService.create(goodsId, name, phone);
            log.info("下单成功：订单信息{}", order);

            //发送异步消息：预扣减库存成功，创建订单
            //SecondKillVO secondKillVO = new SecondKillVO(goodsId, name, phone);
            //kafkaTemplate.send("topic_second_kill", JSONObject.toJSONString(secondKillVO));
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("抢购失败");
        }
        return ResponseMessage.ok();
    }
}
