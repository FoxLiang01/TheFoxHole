package com.ruoyi.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.business.domain.FoxCategory;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.business.domain.FoxComment;
import com.ruoyi.business.vo.FoxCommentVo;
import com.ruoyi.business.mapper.FoxCommentMapper;
import com.ruoyi.business.service.IFoxCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 评论Service业务层处理
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Service
public class FoxCommentServiceImpl extends ServiceImpl<FoxCommentMapper, FoxComment> implements IFoxCommentService {

    @Autowired
    private FoxCommentMapper foxCommentMapper;

    /**
     * 查询评论
     *
     * @param id 评论主键
     * @return 评论
     */
    @Override
    public FoxComment selectFoxCommentById(Long id)
    {
        return foxCommentMapper.selectFoxCommentById(id);
    }

    /**
     * 查询评论列表
     *
     * @param foxComment 评论
     * @return 评论
     */
    @Override
    public List<Map<String, Object>> selectFoxCommentList(Map<String, Object> params)
    {
        return foxCommentMapper.selectFoxCommentList(params);
    }

    /**
     * 新增评论
     *
     * @param foxComment 评论
     * @return 结果
     */
    @Override
    @Transactional
    public void insertFoxComment(FoxComment foxComment)
    {
        this.save(foxComment);
    }

    /**
     * 修改评论
     *
     * @param foxComment 评论
     * @return 结果
     */
    @Override
    @Transactional
    public void updateFoxComment(FoxComment foxComment)
    {
        this.updateById(foxComment);
    }

    /**
     * 批量删除评论
     *
     * @param ids 需要删除的评论主键
     * @return 结果
     */
    @Override
    public void deleteFoxCommentByIds(Long[] ids)
    {
        UpdateWrapper<FoxComment> updateWrapper =new UpdateWrapper();
        updateWrapper.in("id", ids);
        updateWrapper.eq("del_flag", "0");
        updateWrapper.set("del_flag", "2");
        this.update(updateWrapper);
    }

    /**
     * 删除评论信息
     *
     * @param id 评论主键
     * @return 结果
     */
    @Override
    public void deleteFoxCommentById(Long id)
    {
        UpdateWrapper<FoxComment> updateWrapper =new UpdateWrapper();
        updateWrapper.eq("id", id);
        updateWrapper.eq("del_flag", "0");
        updateWrapper.set("del_flag", "2");
        this.update(updateWrapper);
    }
}
