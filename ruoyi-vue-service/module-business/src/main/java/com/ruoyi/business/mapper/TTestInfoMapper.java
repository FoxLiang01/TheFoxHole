package com.ruoyi.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.business.domain.TTestInfo;
import com.ruoyi.business.vo.TTestInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 测试Mapper接口
 *
 * @author Tellsea
 * @date 2022-09-02
 */
public interface TTestInfoMapper extends BaseMapper<TTestInfo> {

    Page<TTestInfoVo> queryList(Page<?> page, @Param("entity") TTestInfoVo entity);

    List<TTestInfoVo> queryList(@Param("entity") TTestInfoVo entity);

    TTestInfoVo queryById(@Param("id") Long id);

}
