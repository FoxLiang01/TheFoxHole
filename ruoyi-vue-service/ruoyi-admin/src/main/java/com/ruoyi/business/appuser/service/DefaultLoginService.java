package com.ruoyi.business.appuser.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginBody;

/**
 * 账号密码登录
 *
 * @author Tellsea
 * @date 2022/9/2
 */
public interface DefaultLoginService {

    /**
     * 登录获取Token
     *
     * @param entity
     * @return
     */
    AjaxResult login(LoginBody entity);

    /**
     * 获取用户信息
     *
     * @return
     */
    AjaxResult getInfo();
}
