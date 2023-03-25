package com.ruoyi.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.business.domain.FoxWork;
import com.ruoyi.business.vo.FoxWorkVo;
import com.ruoyi.business.mapper.FoxWorkMapper;
import com.ruoyi.business.service.IFoxWorkService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 连载文章Service业务层处理
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Service
public class FoxWorkServiceImpl extends ServiceImpl<FoxWorkMapper, FoxWork> implements IFoxWorkService {

    @Override
    public TableDataInfo<FoxWorkVo> queryList(FoxWorkVo entity) {
        return PageUtils.buildDataInfo(this.baseMapper.queryList(PageUtils.buildPage(), entity));
    }

    @Override
    public List<FoxWorkVo> queryAll(FoxWorkVo entity) {
        return this.baseMapper.queryList(entity);
    }

    @Override
    public FoxWorkVo queryById(Long id) {
        return this.baseMapper.queryById(id);
    }
}
