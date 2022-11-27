package com.zty.handler;

import com.alibaba.fastjson.JSON;
import com.zty.domain.ResponseResult;
import com.zty.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version V1.0
 * @ClassName: com.zty.handler.AccessDeniedHandlerImpl.java
 * @Copyright swpu
 * @author: zty-f
 * @date: 2022-11-27 11:16
 * @Description: 自定义授权失败异常处理类
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResponseResult result = new ResponseResult(HttpStatus.FORBIDDEN.value(),"用户授权失败，请联系管理员！");

        String jsonString = JSON.toJSONString(result);
        //处理异常
        WebUtils.renderString(response,jsonString);
    }
}
