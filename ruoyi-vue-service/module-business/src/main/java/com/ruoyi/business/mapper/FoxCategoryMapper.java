package com.ruoyi.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.business.domain.FoxCategory;
import com.ruoyi.business.vo.FoxCategoryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 合集Mapper接口
 *
 * @author Foxx
 * @date 2023-03-25
 */
public interface FoxCategoryMapper extends BaseMapper<FoxCategory> {

    Page<FoxCategoryVo> queryList(Page<?> page, @Param("entity") FoxCategoryVo entity);

    List<FoxCategoryVo> queryList(@Param("entity") FoxCategoryVo entity);

    FoxCategoryVo queryById(@Param("id") Long id);

}
