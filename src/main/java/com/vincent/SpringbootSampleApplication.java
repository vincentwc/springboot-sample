package com.vincent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.vincent.mapper","com.vincent.liteflow"})
@SpringBootApplication
public class SpringbootSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSampleApplication.class, args);
    }

}
