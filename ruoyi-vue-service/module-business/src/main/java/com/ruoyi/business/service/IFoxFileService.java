package com.ruoyi.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.business.domain.FoxFile;
import com.ruoyi.business.vo.FoxFileVo;

import java.util.List;

/**
 * 文件Service接口
 *
 * @author Foxx
 * @date 2023-03-25
 */
public interface IFoxFileService extends IService<FoxFile> {

    /**
     * 分页查询
     *
     * @param entity
     * @return
     */
    TableDataInfo<FoxFileVo> queryList(FoxFileVo entity);

    /**
     * 查询全部
     *
     * @param entity
     * @return
     */
    List<FoxFileVo> queryAll(FoxFileVo entity);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    FoxFileVo queryById(Long id);
}
