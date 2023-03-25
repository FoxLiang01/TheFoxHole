package com.ruoyi.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.business.domain.FoxCategory;
import com.ruoyi.business.vo.FoxCategoryVo;

import java.util.List;

/**
 * 合集Service接口
 *
 * @author Foxx
 * @date 2023-03-25
 */
public interface IFoxCategoryService extends IService<FoxCategory> {

    /**
     * 分页查询
     *
     * @param entity
     * @return
     */
    TableDataInfo<FoxCategoryVo> queryList(FoxCategoryVo entity);

    /**
     * 查询全部
     *
     * @param entity
     * @return
     */
    List<FoxCategoryVo> queryAll(FoxCategoryVo entity);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    FoxCategoryVo queryById(Long id);
}
