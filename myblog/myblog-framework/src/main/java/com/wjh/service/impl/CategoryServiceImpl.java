package com.wjh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjh.constants.SystemConstants;
import com.wjh.pojo.Article;
import com.wjh.pojo.Category;
import com.wjh.pojo.ResponseResult;
import com.wjh.pojo.vo.CategoryVo;
import com.wjh.service.ArticleService;
import com.wjh.service.CategoryService;
import com.wjh.mapper.CategoryMapper;
import com.wjh.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
* @author PC
* @description 针对表【sg_category(分类表)】的数据库操作Service实现
* @createDate 2022-08-11 15:59:10
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

    @Autowired
    private ArticleService articalService;

    @Override
    public ResponseResult getCategoryList() {
        //先查询文章表 状态为已分类
        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
        articleWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        List<Article> articles = articalService.list(articleWrapper);
        //获取文章分类id 去重
        Set<Long> categoryIds = articles.stream()
                .map(article -> article.getCategoryId())
                .collect(Collectors.toSet());
        //查询分类表
        List<Category> categories = listByIds(categoryIds);
        categories = categories.stream()
                .filter(category -> SystemConstants.STATUS_NORMAL.equals(category.getStatus()))
                .collect(Collectors.toList());
        //封装VO
        List<CategoryVo> categoryVoList = BeanCopyUtils.copyBeanList(categories, CategoryVo.class);
        return ResponseResult.okResult(categoryVoList);
    }
}




