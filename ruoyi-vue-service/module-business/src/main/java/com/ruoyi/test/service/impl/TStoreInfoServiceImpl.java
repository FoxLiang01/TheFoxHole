package com.ruoyi.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.test.domain.TStoreInfo;
import com.ruoyi.test.mapper.TStoreInfoMapper;
import com.ruoyi.test.service.ITStoreInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 门店Service业务层处理
 *
 * @author Tellsea
 * @date 2022-09-01
 */
@Service
public class TStoreInfoServiceImpl extends ServiceImpl<TStoreInfoMapper, TStoreInfo> implements ITStoreInfoService {

    @Override
    public TableDataInfo queryList(TStoreInfo entity) {
        return PageUtils.buildDataInfo(this.baseMapper.queryList(PageUtils.buildPage(), entity));
    }

    @Override
    public List<TStoreInfo> queryAll(TStoreInfo tStoreInfo) {
        return this.baseMapper.queryList(tStoreInfo);
    }

    @Override
    public TStoreInfo queryById(Long id) {
        return this.baseMapper.queryById(id);
    }
}
