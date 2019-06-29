package com.ryoma.gis;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ryoma.gis.dao")
public class GisApplication {
    private final  static Logger log= LoggerFactory.getLogger(GisApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(GisApplication.class, args);
        log.info("gis服务已启动...");
    }

}
