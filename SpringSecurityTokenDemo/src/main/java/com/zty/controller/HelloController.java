package com.zty.controller;

import com.zty.domain.ResponseResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    //@PreAuthorize("hasAuthority('system:test:list')")
    @PreAuthorize("@ex.hasAuthority('system:test:list')") //使用自定义类来处理权限效验
    public String test1(){
        return "Hello World!";
    }

    @PostMapping("/testCors")
    public ResponseResult test2(){
        return new ResponseResult(200,"testCors");
    }
}
