package com.zty;

import com.zty.domain.User;
import com.zty.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Test
    public void testUserMapper(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}
