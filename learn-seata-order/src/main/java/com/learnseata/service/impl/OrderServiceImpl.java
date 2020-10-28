package com.learnseata.service.impl;

import com.learnseata.client.GoodsClient;
import com.learnseata.dao.OrderMapper;
import com.learnseata.pojo.Order;
import com.learnseata.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private GoodsClient goodsClient;

    @Override
    @GlobalTransactional
    public Integer insertOne(Order order) {
        Integer insertCount = orderMapper.insertSelective(order);
        goodsClient.cutGoodsStock(order.getGoods_id(), order.getBuy_number());
        return insertCount;
    }
}
