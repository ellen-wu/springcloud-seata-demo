package com.learnseata.service.impl;

import com.learnseata.dao.GoodsMapper;
import com.learnseata.pojo.Goods;
import com.learnseata.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public void updateStock(Integer id, Integer stockNumber) {
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        System.out.println("1: " + goods);
        if (goods != null) {
            goods.setStock(goods.getStock() - stockNumber);

            System.out.println(goods);
            goodsMapper.updateByPrimaryKeySelective(goods);
        }
    }
}
