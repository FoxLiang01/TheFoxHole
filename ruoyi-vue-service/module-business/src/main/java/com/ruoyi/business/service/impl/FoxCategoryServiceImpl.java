package com.ruoyi.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.business.domain.FoxCategory;
import com.ruoyi.business.vo.FoxCategoryVo;
import com.ruoyi.business.mapper.FoxCategoryMapper;
import com.ruoyi.business.service.IFoxCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 合集Service业务层处理
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Service
public class FoxCategoryServiceImpl extends ServiceImpl<FoxCategoryMapper, FoxCategory> implements IFoxCategoryService {

    @Override
    public TableDataInfo<FoxCategoryVo> queryList(FoxCategoryVo entity) {
        return PageUtils.buildDataInfo(this.baseMapper.queryList(PageUtils.buildPage(), entity));
    }

    @Override
    public List<FoxCategoryVo> queryAll(FoxCategoryVo entity) {
        return this.baseMapper.queryList(entity);
    }

    @Override
    public FoxCategoryVo queryById(Long id) {
        return this.baseMapper.queryById(id);
    }
}
