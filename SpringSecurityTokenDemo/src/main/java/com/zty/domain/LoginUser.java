package com.zty.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version V1.0
 * @ClassName: com.zty.domain.LoginUser.java
 * @Copyright swpu
 * @author: zty-f
 * @date: 2022-11-25 17:15
 * @Description:
 */

@Data
@NoArgsConstructor
public class LoginUser implements UserDetails {
    private User user;

    private List<String> permissions;

    @JSONField(serialize = false) //不能序列化SimpleGrantedAuthority包
    private List<SimpleGrantedAuthority> authorities;

    public LoginUser(User user, List<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities!=null)return authorities;
        //把权限信息封装
        //1.传统写法
        /*List<GrantedAuthority> res = new ArrayList<>();
        for (String permission : permissions) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(permission);
            res.add(simpleGrantedAuthority);
        }*/
        //2.stream流写法
        authorities = permissions.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
