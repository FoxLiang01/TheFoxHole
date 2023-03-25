package com.ruoyi.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.business.domain.FoxWork;
import com.ruoyi.business.vo.FoxWorkVo;

import java.util.List;

/**
 * 连载文章Service接口
 *
 * @author Foxx
 * @date 2023-03-25
 */
public interface IFoxWorkService extends IService<FoxWork> {

    /**
     * 分页查询
     *
     * @param entity
     * @return
     */
    TableDataInfo<FoxWorkVo> queryList(FoxWorkVo entity);

    /**
     * 查询全部
     *
     * @param entity
     * @return
     */
    List<FoxWorkVo> queryAll(FoxWorkVo entity);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    FoxWorkVo queryById(Long id);
}
