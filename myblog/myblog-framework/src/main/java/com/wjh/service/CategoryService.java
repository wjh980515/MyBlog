package com.wjh.service;

import com.wjh.pojo.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wjh.pojo.ResponseResult;

/**
* @author PC
* @description 针对表【sg_category(分类表)】的数据库操作Service
* @createDate 2022-08-11 15:59:10
*/
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}
