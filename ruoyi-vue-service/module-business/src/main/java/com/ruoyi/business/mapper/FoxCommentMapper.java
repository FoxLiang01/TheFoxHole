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
    /**
     * 查询评论
     *
     * @param id 评论主键
     * @return 评论
     */
    public FoxComment selectFoxCommentById(Long id);

    /**
     * 查询评论列表
     *
     * @param foxComment 评论
     * @return 评论集合
     */
    public List<FoxComment> selectFoxCommentList(FoxComment foxComment);

}
