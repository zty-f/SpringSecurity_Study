package com.zty.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zty.domain.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectPermsByUserID(Long userID);
}
