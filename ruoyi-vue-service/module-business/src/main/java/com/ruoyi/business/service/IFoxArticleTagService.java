package com.ruoyi.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.business.domain.FoxArticleTag;
import com.ruoyi.business.vo.FoxArticleTagVo;

import java.util.List;

/**
 * 文章与标题的关联Service接口
 *
 * @author Foxx
 * @date 2023-03-25
 */
public interface IFoxArticleTagService extends IService<FoxArticleTag> {

    /**
     * 分页查询
     *
     * @param entity
     * @return
     */
    TableDataInfo<FoxArticleTagVo> queryList(FoxArticleTagVo entity);

    /**
     * 查询全部
     *
     * @param entity
     * @return
     */
    List<FoxArticleTagVo> queryAll(FoxArticleTagVo entity);

    /**
     * 根据ID查询
     *
     * @param articleId
     * @return
     */
    FoxArticleTagVo queryById(Long articleId);
}
