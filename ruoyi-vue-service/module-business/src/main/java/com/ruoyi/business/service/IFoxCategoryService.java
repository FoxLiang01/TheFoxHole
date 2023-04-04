package com.ruoyi.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.business.domain.FoxCategory;
import com.ruoyi.business.vo.FoxCategoryVo;

import java.util.List;
import java.util.Map;

/**
 * 合集Service接口
 *
 * @author Foxx
 * @date 2023-03-25
 */
public interface IFoxCategoryService extends IService<FoxCategory> {

    /**
     * 查询合集
     *
     * @param id 合集主键
     * @return 合集
     */
    public FoxCategory selectFoxCategoryById(Long id);

    /**
     * 查询合集列表
     *
     * @return 合集集合
     */
    public List<FoxCategory> selectFoxCategoryList(Map<String, Object> params);

    /**
     * 新增合集
     *
     * @param foxCategory 合集
     */
    public void insertFoxCategory(FoxCategory foxCategory);

    /**
     * 修改合集
     *
     * @param foxCategory 合集
     */
    public void updateFoxCategory(FoxCategory foxCategory);

    /**
     * 批量删除合集
     *
     * @param ids 需要删除的合集主键集合
     */
    public void deleteFoxCategoryByIds(Long[] ids);

    /**
     * 删除合集信息
     *
     * @param id 合集主键
     */
    public void deleteFoxCategoryById(Long id);
}
