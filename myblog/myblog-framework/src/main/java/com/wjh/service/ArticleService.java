package com.wjh.service;

import com.wjh.pojo.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wjh.pojo.ResponseResult;

/**
* @author PC
* @description 针对表【sg_article(文章表)】的数据库操作Service
* @createDate 2022-08-11 09:51:18
*/
public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);
}
