package com.zty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @version V1.0
 * @ClassName: com.zty.SecurityApplication.java
 * @Copyright swpu
 * @author: zty-f
 * @date: 2022-11-24 10:45
 * @Description: 启动类
 */

@SpringBootApplication
public class SecurityApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SecurityApplication.class, args);
        System.out.println("启动成功！");
    }
}
