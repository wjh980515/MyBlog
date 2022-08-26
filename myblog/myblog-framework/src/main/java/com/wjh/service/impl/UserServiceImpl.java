package com.wjh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjh.pojo.User;
import com.wjh.service.UserService;
import com.wjh.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author PC
* @description 针对表【sys_user(用户表)】的数据库操作Service实现
* @createDate 2022-08-15 20:07:06
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




