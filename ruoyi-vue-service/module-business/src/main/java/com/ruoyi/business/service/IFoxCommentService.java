package com.ruoyi.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.business.domain.FoxComment;
import com.ruoyi.business.vo.FoxCommentVo;

import java.util.List;
import java.util.Map;

/**
 * 评论Service接口
 *
 * @author Foxx
 * @date 2023-03-25
 */
public interface IFoxCommentService extends IService<FoxComment> {

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
    public List<Map<String, Object>> selectFoxCommentList(Map<String, Object> params);

    /**
     * 新增评论
     *
     * @param foxComment 评论
     * @return 结果
     */
    public void insertFoxComment(FoxComment foxComment);

    /**
     * 修改评论
     *
     * @param foxComment 评论
     * @return 结果
     */
    public void updateFoxComment(FoxComment foxComment);

    /**
     * 批量删除评论
     *
     * @param ids 需要删除的评论主键集合
     * @return 结果
     */
    public void deleteFoxCommentByIds(Long[] ids);

    /**
     * 删除评论信息
     *
     * @param id 评论主键
     * @return 结果
     */
    public void deleteFoxCommentById(Long id);
}
