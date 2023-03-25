package com.ruoyi.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.business.domain.FoxArticleTag;
import com.ruoyi.business.vo.FoxArticleTagVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章与标题的关联Mapper接口
 *
 * @author Foxx
 * @date 2023-03-25
 */
public interface FoxArticleTagMapper extends BaseMapper<FoxArticleTag> {

    Page<FoxArticleTagVo> queryList(Page<?> page, @Param("entity") FoxArticleTagVo entity);

    List<FoxArticleTagVo> queryList(@Param("entity") FoxArticleTagVo entity);

    FoxArticleTagVo queryById(@Param("id") Long articleId);

}
