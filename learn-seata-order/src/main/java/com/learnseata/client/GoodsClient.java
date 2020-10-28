package com.learnseata.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-goods")
public interface GoodsClient {
    @GetMapping("goods/{id}/{number}")
    public void cutGoodsStock(@PathVariable(value = "id")Integer id, @PathVariable(value = "number")Integer number);
}
