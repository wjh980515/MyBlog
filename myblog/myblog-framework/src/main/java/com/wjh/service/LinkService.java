package com.wjh.service;

import com.wjh.pojo.Link;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wjh.pojo.ResponseResult;

/**
* @author PC
* @description 针对表【sg_link(友链)】的数据库操作Service
* @createDate 2022-08-11 15:59:53
*/
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}
