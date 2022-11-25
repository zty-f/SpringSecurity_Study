package com.zty.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zty.domain.LoginUser;
import com.zty.domain.User;
import com.zty.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @version V1.0
 * @ClassName: com.zty.service.impl.UserDetailsService.java
 * @Copyright swpu
 * @author: zty-f
 * @date: 2022-11-25 16:58
 * @Description: 用户信息认证自定义类
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1.通过用户名查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,username);
        User user = userMapper.selectOne(queryWrapper);
        if (null==user){
            throw new UsernameNotFoundException("用户名未找到或者密码错误！");
        }
        System.out.println("查询到的User信息："+user);
        //TODO 2.查询用户权限

        //3.封装成UserDetails返回
        return new LoginUser(user);
    }
}
