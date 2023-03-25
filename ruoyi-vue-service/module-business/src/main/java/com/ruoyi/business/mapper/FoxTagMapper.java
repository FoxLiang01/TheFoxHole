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

    Page<FoxTagVo> queryList(Page<?> page, @Param("entity") FoxTagVo entity);

    List<FoxTagVo> queryList(@Param("entity") FoxTagVo entity);

    FoxTagVo queryById(@Param("id") Long id);

}
