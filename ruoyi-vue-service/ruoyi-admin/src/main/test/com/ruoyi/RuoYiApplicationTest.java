package com.ruoyi;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.business.service.ITTestInfoService;
import com.ruoyi.business.vo.TTestInfoVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RuoYiApplicationTest {

    @Autowired
    private ITTestInfoService testInfoService;

    @Test
    public void saveEntity() {
        TTestInfoVo testInfoVo = new TTestInfoVo();
        testInfoVo.setStoreName("烧烤店");
        testInfoVo.setPicture("烧烤店123456");
        testInfoService.saveEntity(testInfoVo);
    }

    @Test
    public void getEntityById() {
        TTestInfoVo testInfoVo = testInfoService.getEntityById(7);
        System.out.println(JSON.toJSONString(testInfoVo));
    }
}
