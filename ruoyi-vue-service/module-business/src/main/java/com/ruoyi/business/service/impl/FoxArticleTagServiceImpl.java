package com.ruoyi.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.business.domain.FoxArticleTag;
import com.ruoyi.business.vo.FoxArticleTagVo;
import com.ruoyi.business.mapper.FoxArticleTagMapper;
import com.ruoyi.business.service.IFoxArticleTagService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章与标题的关联Service业务层处理
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Service
public class FoxArticleTagServiceImpl extends ServiceImpl<FoxArticleTagMapper, FoxArticleTag> implements IFoxArticleTagService {

    @Override
    public TableDataInfo<FoxArticleTagVo> queryList(FoxArticleTagVo entity) {
        return PageUtils.buildDataInfo(this.baseMapper.queryList(PageUtils.buildPage(), entity));
    }

    @Override
    public List<FoxArticleTagVo> queryAll(FoxArticleTagVo entity) {
        return this.baseMapper.queryList(entity);
    }

    @Override
    public FoxArticleTagVo queryById(Long articleId) {
        return this.baseMapper.queryById(articleId);
    }
}
