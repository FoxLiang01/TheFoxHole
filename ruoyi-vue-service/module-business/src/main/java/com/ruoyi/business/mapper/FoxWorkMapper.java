package com.ruoyi.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.business.domain.FoxWork;
import com.ruoyi.business.vo.FoxWorkVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 连载文章Mapper接口
 *
 * @author Foxx
 * @date 2023-03-25
 */
public interface FoxWorkMapper extends BaseMapper<FoxWork> {

    Page<FoxWorkVo> queryList(Page<?> page, @Param("entity") FoxWorkVo entity);

    List<FoxWorkVo> queryList(@Param("entity") FoxWorkVo entity);

    FoxWorkVo queryById(@Param("id") Long id);

}
