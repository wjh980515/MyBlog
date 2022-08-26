package com.wjh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjh.constants.SystemConstants;
import com.wjh.pojo.Link;
import com.wjh.pojo.ResponseResult;
import com.wjh.pojo.vo.LinkVo;
import com.wjh.service.LinkService;
import com.wjh.mapper.LinkMapper;
import com.wjh.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author PC
* @description 针对表【sg_link(友链)】的数据库操作Service实现
* @createDate 2022-08-11 15:59:53
*/
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link>
    implements LinkService{

    @Override
    public ResponseResult getAllLink() {
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_NORMAL);
        List<Link> linkList = list(queryWrapper);
        List<LinkVo> linkVoList = BeanCopyUtils.copyBeanList(linkList, LinkVo.class);
        return ResponseResult.okResult(linkVoList);
    }
}




