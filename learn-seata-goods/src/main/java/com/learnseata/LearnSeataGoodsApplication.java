package com.learnseata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.learnseata.dao")
public class LearnSeataGoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSeataGoodsApplication.class, args);
    }

}
