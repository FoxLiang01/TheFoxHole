package com.ruoyi.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.test.domain.TStoreInfo;

import java.util.List;

/**
 * 门店Service接口
 *
 * @author Tellsea
 * @date 2022-09-01
 */
public interface ITStoreInfoService extends IService<TStoreInfo> {

    /**
     * 分页查询
     *
     * @param entity
     * @return
     */
    TableDataInfo queryList(TStoreInfo entity);

    /**
     * 查询全部
     *
     * @param entity
     * @return
     */
    List<TStoreInfo> queryAll(TStoreInfo entity);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    TStoreInfo queryById(Long id);
}
