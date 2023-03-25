package com.ruoyi.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.business.domain.FoxComment;
import com.ruoyi.business.vo.FoxCommentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 评论Mapper接口
 *
 * @author Foxx
 * @date 2023-03-25
 */
public interface FoxCommentMapper extends BaseMapper<FoxComment> {

    Page<FoxCommentVo> queryList(Page<?> page, @Param("entity") FoxCommentVo entity);

    List<FoxCommentVo> queryList(@Param("entity") FoxCommentVo entity);

    FoxCommentVo queryById(@Param("id") Long id);

}
