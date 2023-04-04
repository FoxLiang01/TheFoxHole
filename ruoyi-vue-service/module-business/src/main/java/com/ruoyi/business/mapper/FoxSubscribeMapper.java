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

    /**
     * 查询订阅
     *
     * @param id 订阅主键
     * @return 订阅
     */
    public FoxSubscribe selectFoxSubscribeById(Long id);

    /**
     * 查询订阅列表
     *
     * @param foxSubscribe 订阅
     * @return 订阅集合
     */
    public List<FoxSubscribe> selectFoxSubscribeList(FoxSubscribe foxSubscribe);

}
