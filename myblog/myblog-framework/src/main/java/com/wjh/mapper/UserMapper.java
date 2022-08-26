package com.wjh.mapper;

import com.wjh.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author PC
* @description 针对表【sys_user(用户表)】的数据库操作Mapper
* @createDate 2022-08-15 20:07:06
* @Entity com.wjh.pojo.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




