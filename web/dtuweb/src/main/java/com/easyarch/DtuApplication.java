package com.easyarch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@MapperScan("com.easyarch.mapper")
@SpringBootApplication
public class DtuApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DtuApplication.class, args);
        System.out.println("容器创建成功：" + run);
    }
}
