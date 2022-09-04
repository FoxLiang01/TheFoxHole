package com.ruoyi.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.business.domain.TTestInfo;
import com.ruoyi.business.vo.TTestInfoVo;
import com.ruoyi.business.mapper.TTestInfoMapper;
import com.ruoyi.business.service.ITTestInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试Service业务层处理
 *
 * @author Tellsea
 * @date 2022-09-02
 */
@Service
public class TTestInfoServiceImpl extends ServiceImpl<TTestInfoMapper, TTestInfo> implements ITTestInfoService {

    @Override
    public TableDataInfo<TTestInfoVo> queryList(TTestInfoVo entity) {
        return PageUtils.buildDataInfo(this.baseMapper.queryList(PageUtils.buildPage(), entity));
    }

    @Override
    public List<TTestInfoVo> queryAll(TTestInfoVo entity) {
        return this.baseMapper.queryList(entity);
    }

    @Override
    public TTestInfoVo queryById(Long id) {
        return this.baseMapper.queryById(id);
    }

    @Override
    public void saveEntity(TTestInfoVo entity) {
        this.baseMapper.saveEntity(entity);
    }

    @Override
    public TTestInfoVo getEntityById(int id) {
        return this.baseMapper.getEntityById(id);
    }
}
