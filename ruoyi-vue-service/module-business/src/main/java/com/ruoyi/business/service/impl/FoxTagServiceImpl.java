package com.ruoyi.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.business.domain.FoxTag;
import com.ruoyi.business.mapper.FoxTagMapper;
import com.ruoyi.business.service.IFoxTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 标签Service业务层处理
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Service
public class FoxTagServiceImpl extends ServiceImpl<FoxTagMapper, FoxTag> implements IFoxTagService {

    @Autowired
    private FoxTagMapper foxTagMapper;

    /**
     * 查询标签
     *
     * @param id 标签主键
     * @return 标签
     */
    @Override
    public FoxTag selectFoxTagById(Long id)
    {
        return foxTagMapper.selectFoxTagById(id);
    }

    /**
     * 查询标签列表
     *
     * @param foxTag 标签
     * @return 标签
     */
    @Override
    public List<FoxTag> selectFoxTagList(FoxTag foxTag)
    {
        return foxTagMapper.selectFoxTagList(foxTag);
    }

    /**
     * 新增标签
     *
     * @param foxTag 标签
     * @return 结果
     */
    @Override
    @Transactional
    public void insertFoxTag(FoxTag foxTag)
    {
        this.save(foxTag);
    }

    /**
     * 修改标签
     *
     * @param foxTag 标签
     * @return 结果
     */
    @Override
    @Transactional
    public void updateFoxTag(FoxTag foxTag)
    {
        this.updateById(foxTag);
    }

    /**
     * 批量删除标签
     *
     * @param ids 需要删除的标签主键
     * @return 结果
     */
    @Override
    public void deleteFoxTagByIds(Long[] ids)
    {
        UpdateWrapper<FoxTag> updateWrapper =new UpdateWrapper();
        updateWrapper.in("id", ids);
        updateWrapper.eq("del_flag", "0");
        updateWrapper.set("del_flag", "2");
        this.update(updateWrapper);
    }

    /**
     * 删除标签信息
     *
     * @param id 标签主键
     * @return 结果
     */
    @Override
    public void deleteFoxTagById(Long id)
    {
        UpdateWrapper<FoxTag> updateWrapper =new UpdateWrapper();
        updateWrapper.eq("id", id);
        updateWrapper.eq("del_flag", "0");
        updateWrapper.set("del_flag", "2");
        this.update(updateWrapper);
    }
}
