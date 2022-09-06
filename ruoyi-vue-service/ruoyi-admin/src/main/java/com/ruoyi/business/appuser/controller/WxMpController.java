package com.ruoyi.business.appuser.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信公众号控制器
 *
 * @author Tellsea
 * @date 2022/9/6
 */
@Api("微信公众号控制器")
@RestController
@RequestMapping("/au/wxMp")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class WxMpController {
}
