package com.ruoyi.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.business.domain.TTestInfo;
import com.ruoyi.business.vo.TTestInfoVo;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.List;

/**
 * 测试Service接口
 *
 * @author Tellsea
 * @date 2022-09-02
 */
public interface ITTestInfoService extends IService<TTestInfo> {

    /**
     * 分页查询
     *
     * @param entity
     * @return
     */
    TableDataInfo<TTestInfoVo> queryList(TTestInfoVo entity);

    /**
     * 查询全部
     *
     * @param entity
     * @return
     */
    List<TTestInfoVo> queryAll(TTestInfoVo entity);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    TTestInfoVo queryById(Long id);
}
