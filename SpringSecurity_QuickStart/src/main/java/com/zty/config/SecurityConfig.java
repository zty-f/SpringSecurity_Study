package com.zty.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationSuccessHandler mySuccessHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置自定义登录成功处理器
        http.formLogin().successHandler(mySuccessHandler);

        http.authorizeRequests().anyRequest().authenticated();
    }
}