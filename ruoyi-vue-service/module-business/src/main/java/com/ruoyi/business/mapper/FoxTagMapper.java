package com.ruoyi.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.business.domain.FoxTag;
import com.ruoyi.business.vo.FoxTagVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 标签Mapper接口
 *
 * @author Foxx
 * @date 2023-03-25
 */
public interface FoxTagMapper extends BaseMapper<FoxTag> {

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

}
