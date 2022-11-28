package com.zty.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationSuccessHandler mySuccessHandler;

    @Autowired
    private AuthenticationFailureHandler failureHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
        //配置自定义登录成功处理器
                .successHandler(mySuccessHandler)
        //配置自定义登录失败处理器
                .failureHandler(failureHandler);

        http.authorizeRequests().anyRequest().authenticated();
    }
}