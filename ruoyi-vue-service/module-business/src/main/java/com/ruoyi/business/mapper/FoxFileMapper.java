package com.ruoyi.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.business.domain.FoxFile;
import com.ruoyi.business.vo.FoxFileVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文件Mapper接口
 *
 * @author Foxx
 * @date 2023-03-25
 */
public interface FoxFileMapper extends BaseMapper<FoxFile> {

    Page<FoxFileVo> queryList(Page<?> page, @Param("entity") FoxFileVo entity);

    List<FoxFileVo> queryList(@Param("entity") FoxFileVo entity);

    FoxFileVo queryById(@Param("id") Long id);

}
