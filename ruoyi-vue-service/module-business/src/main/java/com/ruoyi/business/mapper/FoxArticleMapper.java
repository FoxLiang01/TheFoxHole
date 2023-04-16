package com.ruoyi.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.business.domain.FoxArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
     * @return 文章集合
     */
    public List<Map<String, Object>> selectFoxArticleList(@Param("params") Map<String, Object> params);

}
