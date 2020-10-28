package com.learnseata.contrller;

import com.learnseata.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/{id}/{number}")
    @ResponseBody
    public String updateStock(@PathVariable(value = "id")Integer id, @PathVariable(value = "number")Integer stockNumber) {
        goodsService.updateStock(id, stockNumber);
        // 测试
//        Integer test = 10/0;

        System.out.println("商品id: " + id + "，减库存: " + stockNumber);

        return "库存更新成功！";
    }
}
