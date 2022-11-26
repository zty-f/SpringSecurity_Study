package com.zty.service.impl;

import com.zty.domain.LoginUser;
import com.zty.domain.ResponseResult;
import com.zty.domain.User;
import com.zty.service.LoginService;
import com.zty.utils.JwtUtil;
import com.zty.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @version V1.0
 * @ClassName: com.zty.service.impl.LoginServiceImpl.java
 * @Copyright swpu
 * @author: zty-f
 * @date: 2022-11-25 20:51
 * @Description:
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        //调用AuthenticationManager authenticationManager进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        //如果认证没通过，给出提示
        if (Objects.isNull(authentication)){
            throw new RuntimeException("登录失败！");
        }
        //认证通过，使用userid生成jwt返回前端，并userid为key，用户信息为value存入redis
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        Map<String, String> map = new HashMap<>();
        map.put("token",jwt);
        redisCache.setCacheObject("login:"+userId,loginUser);
        return new ResponseResult(200,"登录成功",map);
    }
}
