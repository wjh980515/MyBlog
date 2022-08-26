package com.wjh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjh.pojo.Tag;
import com.wjh.service.TagService;
import com.wjh.mapper.TagMapper;
import org.springframework.stereotype.Service;

/**
* @author PC
* @description 针对表【sg_tag(标签)】的数据库操作Service实现
* @createDate 2022-08-11 15:59:59
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




