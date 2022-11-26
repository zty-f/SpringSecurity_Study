package com.zty.filter;

import com.zty.domain.LoginUser;
import com.zty.utils.JwtUtil;
import com.zty.utils.RedisCache;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @version V1.0
 * @ClassName: com.zty.filter.JwtAuthenticationTokenFilter.java
 * @Copyright swpu
 * @author: zty-f
 * @date: 2022-11-26 15:41
 * @Description: 统一接口token效验过滤器
 */

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //1.获取token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)){
            filterChain.doFilter(request,response);
            return;
        }
        String userID;
        //2.解析token
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userID = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        //3.通过解析的userID去redis查询用户信息
        LoginUser loginUser = redisCache.getCacheObject("login:" + userID);
        System.out.println(loginUser);
        if(Objects.isNull(loginUser)) {
            throw new RuntimeException("用户未登录");
        }
        //4.存入SecurityContextHolder供后续过滤器使用
        //5.存入权限信息
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //6.放行
        filterChain.doFilter(request,response);
    }
}
