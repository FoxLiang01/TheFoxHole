package com.ruoyi.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.business.domain.FoxArticle;
import com.ruoyi.business.domain.FoxCategory;
import com.ruoyi.business.mapper.FoxCategoryMapper;
import com.ruoyi.business.service.IFoxCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 合集Service业务层处理
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Service
public class FoxCategoryServiceImpl extends ServiceImpl<FoxCategoryMapper, FoxCategory> implements IFoxCategoryService {

    @Resource
    private FoxCategoryMapper foxCategoryMapper;

    /**
     * 查询合集
     *
     * @param id 合集主键
     * @return 合集
     */
    @Override
    public FoxCategory selectFoxCategoryById(Long id)
    {
        return foxCategoryMapper.selectFoxCategoryById(id);
    }

    /**
     * 查询合集列表
     *
     * @return 合集
     */
    @Override
    public List<FoxCategory> selectFoxCategoryList(Map<String, Object> params)
    {
        return foxCategoryMapper.selectFoxCategoryList(params);
    }

    /**
     * 新增合集
     *
     * @param foxCategory 合集
     */
    @Override
    @Transactional
    public void insertFoxCategory(FoxCategory foxCategory)
    {
        this.save(foxCategory);
    }

    /**
     * 修改合集
     *
     * @param foxCategory 合集
     * @return 结果
     */
    @Override
    @Transactional
    public void updateFoxCategory(FoxCategory foxCategory)
    {
        this.updateById(foxCategory);
    }

    /**
     * 批量删除合集
     *
     * @param ids 需要删除的合集主键
     */
    @Override
    public void deleteFoxCategoryByIds(Long[] ids)
    {
        UpdateWrapper<FoxCategory> updateWrapper = new UpdateWrapper<>();
        updateWrapper.in("id", ids);
        updateWrapper.eq("del_flag", "0");
        updateWrapper.set("del_flag", "2");
        this.update(updateWrapper);
    }

    /**
     * 删除合集信息
     *
     * @param id 合集主键
     */
    @Override
    public void deleteFoxCategoryById(Long id)
    {
        UpdateWrapper<FoxCategory> updateWrapper =new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        updateWrapper.eq("del_flag", "0");
        updateWrapper.set("del_flag", "2");
        this.update(updateWrapper);
    }
}
