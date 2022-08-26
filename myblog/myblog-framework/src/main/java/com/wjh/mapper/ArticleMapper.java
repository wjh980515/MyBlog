package com.wjh.mapper;

import com.wjh.pojo.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author PC
* @description 针对表【sg_article(文章表)】的数据库操作Mapper
* @createDate 2022-08-11 09:51:18
* @Entity .pojo.Article
*/
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}




