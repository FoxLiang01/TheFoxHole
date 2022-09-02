package com.ruoyi.business.appuser.service.impl;

import com.ruoyi.business.appuser.service.DefaultLoginService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginBody;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.framework.web.service.SysLoginService;
import com.ruoyi.framework.web.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * 账号密码登录
 *
 * @author Tellsea
 * @date 2022/9/2
 */
@Service
public class DefaultLoginServiceImpl implements DefaultLoginService {

    @Autowired
    private SysLoginService loginService;
    @Autowired
    private SysPermissionService permissionService;

    @Override
    public AjaxResult login(LoginBody entity) {
        return AjaxResult.success("登录成功", loginService.login(entity.getUsername(), entity.getPassword()));
    }

    @Override
    public AjaxResult getInfo() {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }
}
