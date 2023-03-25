package com.ruoyi.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.business.domain.FoxTag;
import com.ruoyi.business.vo.FoxTagVo;
import com.ruoyi.business.mapper.FoxTagMapper;
import com.ruoyi.business.service.IFoxTagService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标签Service业务层处理
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Service
public class FoxTagServiceImpl extends ServiceImpl<FoxTagMapper, FoxTag> implements IFoxTagService {

    @Override
    public TableDataInfo<FoxTagVo> queryList(FoxTagVo entity) {
        return PageUtils.buildDataInfo(this.baseMapper.queryList(PageUtils.buildPage(), entity));
    }

    @Override
    public List<FoxTagVo> queryAll(FoxTagVo entity) {
        return this.baseMapper.queryList(entity);
    }

    @Override
    public FoxTagVo queryById(Long id) {
        return this.baseMapper.queryById(id);
    }
}
