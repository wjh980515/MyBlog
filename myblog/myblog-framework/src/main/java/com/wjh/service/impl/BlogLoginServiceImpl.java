package com.wjh.service.impl;

import com.wjh.pojo.LoginUser;
import com.wjh.pojo.ResponseResult;
import com.wjh.pojo.User;
import com.wjh.pojo.vo.BlogUserLoginVo;
import com.wjh.pojo.vo.UserInfoVo;
import com.wjh.service.BlogLoginService;
import com.wjh.utils.BeanCopyUtils;
import com.wjh.utils.JwtUtil;
import com.wjh.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BlogLoginServiceImpl
        implements BlogLoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        //System.out.println("BlogLoginServiceImpl+++");
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if (Objects.isNull(authentication)){
            throw new RuntimeException("用户名或密码错误");
        }
        //获取userid生成token
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String id = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(id);
        //用户信息存入redis
        redisCache.setCacheObject("bloglogin:" + id,loginUser);
        //把token和userinfo封装
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);
        BlogUserLoginVo blogUserLoginVo = new BlogUserLoginVo(jwt,userInfoVo);
        //System.out.println("BlogLoginServiceImpl---");
        return ResponseResult.okResult(blogUserLoginVo);
    }
}
