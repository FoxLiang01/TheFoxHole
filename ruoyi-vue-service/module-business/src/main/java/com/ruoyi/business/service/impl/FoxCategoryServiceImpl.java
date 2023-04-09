package com.ruoyi.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.business.domain.FoxArticle;
import com.ruoyi.business.domain.FoxCategory;
import com.ruoyi.business.mapper.FoxCategoryMapper;
import com.ruoyi.business.service.IFoxCategoryService;
import com.ruoyi.common.core.domain.TreeSelect;
import com.sun.org.apache.bcel.internal.generic.FCMPG;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public List<Map<String, Object>> selectFoxCategoryList(Map<String, Object> params)
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

    /**
     * 获取根节点
     *
     */
    @Override
    public List<Map<String, Object>> getTreeList(List<Map<String, Object>> allList){
        List<FoxCategory> second = baseMapper.selectFoxCategoryChildList();
        List<Map<String, Object>> rlist = new ArrayList<>();
        for(int i = 0 ; i < allList.size();i++){
            Map<String, Object> map = allList.get(i);
            Long firstId = Long.valueOf(allList.get(i).get("id").toString());
            buildTree(firstId,map,second);
            rlist.add(map);
        }
        return rlist;
    }

    /**
     * 构造树结构
     *
//     * @param node 根节点
//     * @param allList 列表所有的数据
     */
    @Override
    public void buildTree(Long parentId, Map<String,Object> map, List<FoxCategory> second){
        List<FoxCategory> seconds = second.stream().filter(temp-> temp.getMetaCategory()!=null && temp.getMetaCategory().equals(parentId)).collect(Collectors.toList());
        if(seconds.size()>0){
           List<Map<String,Object>> childList = new ArrayList<>();
            for(int j = 0 ; j < seconds.size(); j ++){
                Map<String,Object> child = new HashMap<>();
                child.put("id",seconds.get(j).getId());
                child.put("name",seconds.get(j).getName());
                child.put("status",seconds.get(j).getStatus());
                child.put("path",seconds.get(j).getPath());
                childList.add(child);
                buildTree(seconds.get(j).getId(), child, second);
            }
            map.put("children",childList);
        }
    }
}
