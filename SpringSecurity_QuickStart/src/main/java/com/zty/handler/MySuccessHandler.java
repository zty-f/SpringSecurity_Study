package com.zty.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version V1.0
 * @ClassName: com.zty.handler.MySuccessHandler.java
 * @Copyright swpu
 * @author: zty-f
 * @date: 2022-11-28 11:22
 * @Description: 自定义登录成功的处理器
 */
@Component
public class MySuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("认证成功！登录成功！！！！！！");
    }
}
