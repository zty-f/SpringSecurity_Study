package com.zty.expression;

import com.zty.domain.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @version V1.0
 * @ClassName: com.zty.expression.ZTYSecurityExpressionRoot.java
 * @Copyright swpu
 * @author: zty-f
 * @date: 2022-11-28 10:32
 * @Description: 自定义权限控制类
 */
@Component("ex")
public class ZTYSecurityExpressionRoot{

    public  boolean hasAuthority(String authority) {
        //获取用户权限
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        List<String> authorities = loginUser.getPermissions();
        //判断用户是否包含传入权限
        return authorities.contains(authority);
    }
}
