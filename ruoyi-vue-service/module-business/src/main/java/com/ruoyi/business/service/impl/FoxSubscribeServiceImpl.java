package com.ruoyi.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.business.domain.FoxComment;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.business.domain.FoxSubscribe;
import com.ruoyi.business.vo.FoxSubscribeVo;
import com.ruoyi.business.mapper.FoxSubscribeMapper;
import com.ruoyi.business.service.IFoxSubscribeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 订阅Service业务层处理
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Service
public class FoxSubscribeServiceImpl extends ServiceImpl<FoxSubscribeMapper, FoxSubscribe> implements IFoxSubscribeService {

    @Autowired
    private FoxSubscribeMapper foxSubscribeMapper;

    /**
     * 查询订阅
     *
     * @param id 订阅主键
     * @return 订阅
     */
    @Override
    public FoxSubscribe selectFoxSubscribeById(Long id)
    {
        return foxSubscribeMapper.selectFoxSubscribeById(id);
    }

    /**
     * 查询订阅列表
     *
     * @param foxSubscribe 订阅
     * @return 订阅
     */
    @Override
    public List<Map<String, Object>> selectFoxSubscribeList(@Param("params") Map<String, Object> params)
    {
        return foxSubscribeMapper.selectFoxSubscribeList(params);
    }

    /**
     * 新增订阅
     *
     * @param foxSubscribe 订阅
     * @return 结果
     */
    @Override
    @Transactional
    public void insertFoxSubscribe(FoxSubscribe foxSubscribe)
    {
        this.save(foxSubscribe);
    }

    /**
     * 修改订阅
     *
     * @param foxSubscribe 订阅
     * @return 结果
     */
    @Override
    @Transactional
    public void updateFoxSubscribe(FoxSubscribe foxSubscribe)
    {
        this.updateById(foxSubscribe);
    }

    /**
     * 批量删除订阅
     *
     * @param ids 需要删除的订阅主键
     * @return 结果
     */
    @Override
    public void deleteFoxSubscribeByIds(Long[] ids)
    {
        UpdateWrapper<FoxSubscribe> updateWrapper =new UpdateWrapper();
        updateWrapper.in("id", ids);
        updateWrapper.eq("del_flag", "0");
        updateWrapper.set("del_flag", "2");
        this.update(updateWrapper);
    }

    /**
     * 删除订阅信息
     *
     * @param id 订阅主键
     * @return 结果
     */
    @Override
    public void deleteFoxSubscribeById(Long id)
    {
        UpdateWrapper<FoxSubscribe> updateWrapper =new UpdateWrapper();
        updateWrapper.eq("id", id);
        updateWrapper.eq("del_flag", "0");
        updateWrapper.set("del_flag", "2");
        this.update(updateWrapper);
    }
}
