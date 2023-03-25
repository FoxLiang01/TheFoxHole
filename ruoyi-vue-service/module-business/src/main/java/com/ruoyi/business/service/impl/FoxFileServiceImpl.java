package com.ruoyi.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.business.domain.FoxFile;
import com.ruoyi.business.vo.FoxFileVo;
import com.ruoyi.business.mapper.FoxFileMapper;
import com.ruoyi.business.service.IFoxFileService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文件Service业务层处理
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Service
public class FoxFileServiceImpl extends ServiceImpl<FoxFileMapper, FoxFile> implements IFoxFileService {

    @Override
    public TableDataInfo<FoxFileVo> queryList(FoxFileVo entity) {
        return PageUtils.buildDataInfo(this.baseMapper.queryList(PageUtils.buildPage(), entity));
    }

    @Override
    public List<FoxFileVo> queryAll(FoxFileVo entity) {
        return this.baseMapper.queryList(entity);
    }

    @Override
    public FoxFileVo queryById(Long id) {
        return this.baseMapper.queryById(id);
    }
}
