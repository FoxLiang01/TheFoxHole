package com.ruoyi.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.business.domain.FoxSubscribe;
import com.ruoyi.business.vo.FoxSubscribeVo;

import java.util.List;

/**
 * 订阅Service接口
 *
 * @author Foxx
 * @date 2023-03-25
 */
public interface IFoxSubscribeService extends IService<FoxSubscribe> {

    /**
     * 分页查询
     *
     * @param entity
     * @return
     */
    TableDataInfo<FoxSubscribeVo> queryList(FoxSubscribeVo entity);

    /**
     * 查询全部
     *
     * @param entity
     * @return
     */
    List<FoxSubscribeVo> queryAll(FoxSubscribeVo entity);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    FoxSubscribeVo queryById(Long id);
}
