package com.easyarch.mapper.login;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easyarch.entity.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper extends BaseMapper<Users> {

    Users selectOneByUserName(String username);

}
