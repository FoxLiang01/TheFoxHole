package com.ruoyi.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.test.domain.TStoreInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 门店Mapper接口
 *
 * @author Tellsea
 * @date 2022-09-01
 */
public interface TStoreInfoMapper extends BaseMapper<TStoreInfo> {

    Page<TStoreInfo> queryList(Page<?> page, @Param("entity") TStoreInfo entity);

    List<TStoreInfo> queryList(@Param("entity") TStoreInfo entity);

    TStoreInfo queryById(@Param("id") Long id);

}
