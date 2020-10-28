package com.learnseata.controller;


import com.learnseata.pojo.Order;
import com.learnseata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    @ResponseBody
    public String createOne() {
        Integer timeNow = Math.toIntExact(System.currentTimeMillis() / 1000);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Random random = new Random();

        Integer goodsId = random.nextInt(3) + 1;
        Integer buyNumber = random.nextInt(9) + 1;

        // 新增订单
        Order order = new Order();
        order.setOrder_no(dateFormat.format(date) + random.nextInt(10000));
        order.setCreate_time(timeNow);
        order.setGoods_id(goodsId);
        order.setBuy_number(buyNumber);
        order.setOut_order_no(dateFormat.format(date) + random.nextInt(10000));
        order.setStatus((byte) 1);

        Integer insertCount = orderService.insertOne(order);

        System.out.println("商品[" + goodsId + "]库存减少了: " + buyNumber + "件");

        return "订单创建成功";
    }
}
