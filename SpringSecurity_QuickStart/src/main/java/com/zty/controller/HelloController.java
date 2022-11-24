package com.zty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version V1.0
 * @ClassName: com.zty.controller.HelloController.java
 * @Copyright swpu
 * @author: zty-f
 * @date: 2022-11-24 10:47
 * @Description: 测试
 */

@RestController
public class HelloController {

    @GetMapping("/test")
    public String test1(){
        return "Hello World!";
    }
}
