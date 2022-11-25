package com.zty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @version V1.0
 * @ClassName: com.zty.TokenDemoApplication.java
 * @Copyright swpu
 * @author: zty-f
 * @date: 2022-11-24 21:07
 * @Description: 启动类
 */
@SpringBootApplication
@MapperScan("com.zty.mapper")
public class TokenDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(TokenDemoApplication.class);
    }
}
