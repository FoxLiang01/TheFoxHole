package com.ruoyi.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.business.domain.FoxComment;
import com.ruoyi.business.vo.FoxCommentVo;

import java.util.List;

/**
 * 评论Service接口
 *
 * @author Foxx
 * @date 2023-03-25
 */
public interface IFoxCommentService extends IService<FoxComment> {

    /**
     * 分页查询
     *
     * @param entity
     * @return
     */
    TableDataInfo<FoxCommentVo> queryList(FoxCommentVo entity);

    /**
     * 查询全部
     *
     * @param entity
     * @return
     */
    List<FoxCommentVo> queryAll(FoxCommentVo entity);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    FoxCommentVo queryById(Long id);
}
