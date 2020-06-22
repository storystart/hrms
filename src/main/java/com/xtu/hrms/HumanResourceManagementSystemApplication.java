package com.xtu.hrms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringData ElasticSearch(版本可能不合适)
 */
@MapperScan("com.xtu.hrms.mapper")
@SpringBootApplication
public class HumanResourceManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HumanResourceManagementSystemApplication.class, args);
    }

}
