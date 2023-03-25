package com.ruoyi.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.business.domain.FoxSubscribe;
import com.ruoyi.business.vo.FoxSubscribeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订阅Mapper接口
 *
 * @author Foxx
 * @date 2023-03-25
 */
public interface FoxSubscribeMapper extends BaseMapper<FoxSubscribe> {

    Page<FoxSubscribeVo> queryList(Page<?> page, @Param("entity") FoxSubscribeVo entity);

    List<FoxSubscribeVo> queryList(@Param("entity") FoxSubscribeVo entity);

    FoxSubscribeVo queryById(@Param("id") Long id);

}
