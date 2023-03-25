package com.ruoyi.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.business.domain.FoxTag;
import com.ruoyi.business.vo.FoxTagVo;

import java.util.List;

/**
 * 标签Service接口
 *
 * @author Foxx
 * @date 2023-03-25
 */
public interface IFoxTagService extends IService<FoxTag> {

    /**
     * 分页查询
     *
     * @param entity
     * @return
     */
    TableDataInfo<FoxTagVo> queryList(FoxTagVo entity);

    /**
     * 查询全部
     *
     * @param entity
     * @return
     */
    List<FoxTagVo> queryAll(FoxTagVo entity);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    FoxTagVo queryById(Long id);
}
