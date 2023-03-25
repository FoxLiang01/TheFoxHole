package com.ruoyi.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.business.domain.FoxComment;
import com.ruoyi.business.vo.FoxCommentVo;
import com.ruoyi.business.mapper.FoxCommentMapper;
import com.ruoyi.business.service.IFoxCommentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评论Service业务层处理
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Service
public class FoxCommentServiceImpl extends ServiceImpl<FoxCommentMapper, FoxComment> implements IFoxCommentService {

    @Override
    public TableDataInfo<FoxCommentVo> queryList(FoxCommentVo entity) {
        return PageUtils.buildDataInfo(this.baseMapper.queryList(PageUtils.buildPage(), entity));
    }

    @Override
    public List<FoxCommentVo> queryAll(FoxCommentVo entity) {
        return this.baseMapper.queryList(entity);
    }

    @Override
    public FoxCommentVo queryById(Long id) {
        return this.baseMapper.queryById(id);
    }
}
