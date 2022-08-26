package com.wjh.utils;

import com.wjh.pojo.Article;
import com.wjh.pojo.vo.HotArticleVo;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {

    private BeanCopyUtils() {

    }

    public static <V> V copyBean(Object source,Class<V> clazz){

        V result = null;
        //创建目标对象
        try {
            result = clazz.newInstance();
            //实现属性copy
            BeanUtils.copyProperties(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

        public static <V> List<V> copyBeanList(List<?> list, Class<V> clazz) {
            //使用stream流的形式去遍历
            return list.stream()
                    .map(o -> copyBean(o,clazz))
                    .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Article article = new Article();
        article.setId(2L);
        article.setTitle("hello");

        HotArticleVo hotArticle = copyBean(article,HotArticleVo.class);
        System.out.println(hotArticle);
    }

}
