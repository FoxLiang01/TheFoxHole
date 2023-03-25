package com.ruoyi.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.business.domain.FoxSubscribe;
import com.ruoyi.business.vo.FoxSubscribeVo;
import com.ruoyi.business.mapper.FoxSubscribeMapper;
import com.ruoyi.business.service.IFoxSubscribeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订阅Service业务层处理
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Service
public class FoxSubscribeServiceImpl extends ServiceImpl<FoxSubscribeMapper, FoxSubscribe> implements IFoxSubscribeService {

    @Override
    public TableDataInfo<FoxSubscribeVo> queryList(FoxSubscribeVo entity) {
        return PageUtils.buildDataInfo(this.baseMapper.queryList(PageUtils.buildPage(), entity));
    }

    @Override
    public List<FoxSubscribeVo> queryAll(FoxSubscribeVo entity) {
        return this.baseMapper.queryList(entity);
    }

    @Override
    public FoxSubscribeVo queryById(Long id) {
        return this.baseMapper.queryById(id);
    }
}
