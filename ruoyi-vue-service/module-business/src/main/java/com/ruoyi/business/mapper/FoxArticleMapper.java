package com.ruoyi.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.business.domain.FoxArticle;

import java.util.List;

/**
 * 文章Mapper接口
 *
 * @author Foxx
 * @date 2023-03-25
 */
public interface FoxArticleMapper extends BaseMapper<FoxArticle> {

    /**
     * 查询文章
     *
     * @param id 文章主键
     * @return 文章
     */
    public FoxArticle selectFoxArticleById(Long id);

    /**
     * 查询文章列表
     *
     * @param foxArticle 文章
     * @return 文章集合
     */
    public List<FoxArticle> selectFoxArticleList(FoxArticle foxArticle);

}
