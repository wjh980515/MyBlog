package com.wjh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjh.pojo.Comment;
import com.wjh.service.CommentService;
import com.wjh.mapper.CommentMapper;
import org.springframework.stereotype.Service;

/**
* @author PC
* @description 针对表【sg_comment(评论表)】的数据库操作Service实现
* @createDate 2022-08-11 15:59:45
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

}




