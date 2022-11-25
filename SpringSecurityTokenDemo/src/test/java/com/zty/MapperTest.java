package com.zty;

import com.zty.domain.User;
import com.zty.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * @version V1.0
 * @ClassName: com.zty.MapperTest.java
 * @Copyright swpu
 * @author: zty-f
 * @date: 2022-11-25 16:31
 * @Description:
 */
@SpringBootTest
public class MapperTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testUserMapper(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void testBCryptPasswordEncoder(){
        String passwd = "1234";
        System.out.println(passwordEncoder.encode(passwd));
        System.out.println(passwordEncoder.encode(passwd));
        System.out.println(passwordEncoder.matches("12345", passwordEncoder.encode(passwd)));
        System.out.println(passwordEncoder.matches("1234", "$2a$10$VL/asTD/RMdS1w0U4jeJpe2cpx.FH5211d2OPlN9tOKHS2rHwfGEG"));
    }
}
