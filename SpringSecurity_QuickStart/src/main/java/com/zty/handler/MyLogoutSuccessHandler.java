package com.zty.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version V1.0
 * @ClassName: com.zty.handler.MyLogoutSuccessHandler.java
 * @Copyright swpu
 * @author: zty-f
 * @date: 2022-11-28 16:22
 * @Description: 自定义注销成功处理器
 */
@Configuration
public class MyLogoutSuccessHandler implements LogoutSuccessHandler{
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("注销成功！！！！！！！！！");
    }
}
