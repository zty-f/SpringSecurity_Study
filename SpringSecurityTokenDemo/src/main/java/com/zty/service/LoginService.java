package com.zty.service;

import com.zty.domain.ResponseResult;
import com.zty.domain.User;


public interface LoginService {
    ResponseResult login(User user);
}

