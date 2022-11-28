package com.zty.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version V1.0
 * @ClassName: com.zty.handler.MyFailureHandler.java
 * @Copyright swpu
 * @author: zty-f
 * @date: 2022-11-28 16:12
 * @Description: 自定义登录失败处理器
 */
@Configuration
public class MyFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        System.out.println("登录失败，请重新登陆！--------");
    }
}
