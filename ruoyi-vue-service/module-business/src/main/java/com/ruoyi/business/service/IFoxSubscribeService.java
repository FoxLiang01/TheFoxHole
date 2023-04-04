package com.ruoyi.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.business.domain.FoxSubscribe;
import com.ruoyi.business.vo.FoxSubscribeVo;

import java.util.List;

/**
 * 订阅Service接口
 *
 * @author Foxx
 * @date 2023-03-25
 */
public interface IFoxSubscribeService extends IService<FoxSubscribe> {

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

    /**
     * 新增订阅
     *
     * @param foxSubscribe 订阅
     * @return 结果
     */
    public void insertFoxSubscribe(FoxSubscribe foxSubscribe);

    /**
     * 修改订阅
     *
     * @param foxSubscribe 订阅
     * @return 结果
     */
    public void updateFoxSubscribe(FoxSubscribe foxSubscribe);

    /**
     * 批量删除订阅
     *
     * @param ids 需要删除的订阅主键集合
     * @return 结果
     */
    public void deleteFoxSubscribeByIds(Long[] ids);

    /**
     * 删除订阅信息
     *
     * @param id 订阅主键
     * @return 结果
     */
    public void deleteFoxSubscribeById(Long id);
}
