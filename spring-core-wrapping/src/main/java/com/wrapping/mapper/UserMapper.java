package com.wrapping.mapper;

import com.wrapping.service.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from")
    User getById();
}
