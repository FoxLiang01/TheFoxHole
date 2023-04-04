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
     * 查询标签
     *
     * @param id 标签主键
     * @return 标签
     */
    public FoxTag selectFoxTagById(Long id);

    /**
     * 查询标签列表
     *
     * @param foxTag 标签
     * @return 标签集合
     */
    public List<FoxTag> selectFoxTagList(FoxTag foxTag);

    /**
     * 新增标签
     *
     * @param foxTag 标签
     * @return 结果
     */
    public void insertFoxTag(FoxTag foxTag);

    /**
     * 修改标签
     *
     * @param foxTag 标签
     * @return 结果
     */
    public void updateFoxTag(FoxTag foxTag);

    /**
     * 批量删除标签
     *
     * @param ids 需要删除的标签主键集合
     * @return 结果
     */
    public void deleteFoxTagByIds(Long[] ids);

    /**
     * 删除标签信息
     *
     * @param id 标签主键
     * @return 结果
     */
    public void deleteFoxTagById(Long id);
}
