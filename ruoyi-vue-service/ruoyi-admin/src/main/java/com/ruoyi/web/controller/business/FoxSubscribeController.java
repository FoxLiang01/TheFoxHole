package com.ruoyi.web.controller.business;

import com.ruoyi.business.service.IFoxSubscribeService;
import com.ruoyi.business.vo.FoxSubscribeVo;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 订阅Controller
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Api(tags = "订阅Controller")
@RestController
@RequestMapping("/business/subscribe")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FoxSubscribeController extends BaseController {

    private final IFoxSubscribeService foxSubscribeService;

    @ApiOperation("查询订阅列表")
    @PreAuthorize("@ss.hasPermi('business:subscribe:list')")
    @GetMapping("/list")
    public TableDataInfo<FoxSubscribeVo> list(FoxSubscribeVo entity) {
        return foxSubscribeService.queryList(entity);
    }

    @ApiOperation("查询订阅所有列表")
    @GetMapping("/listAll")
    public AjaxResult listAll(FoxSubscribeVo entity) {
        return AjaxResult.success("查询成功", foxSubscribeService.queryAll(entity));
    }

    @ApiOperation("导出订阅列表")
    @PreAuthorize("@ss.hasPermi('business:subscribe:export')")
    @Log(title = "订阅", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FoxSubscribeVo entity) {
        List<FoxSubscribeVo> list = foxSubscribeService.queryAll(entity);
        ExcelUtil<FoxSubscribeVo> util = new ExcelUtil<>(FoxSubscribeVo.class);
        util.exportExcel(response, list, "订阅数据");
    }

    @ApiOperation("获取订阅详细信息")
    @PreAuthorize("@ss.hasPermi('business:subscribe:query')")
    @GetMapping(value = "/getInfo/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success("查询成功", foxSubscribeService.queryById(id));
    }

    @ApiOperation("新增订阅")
    @PreAuthorize("@ss.hasPermi('business:subscribe:add')")
    @Log(title = "订阅", businessType = BusinessType.INSERT)
    @PostMapping("add")
    public AjaxResult add(@RequestBody FoxSubscribeVo entity) {
        return toAjax(foxSubscribeService.save(entity));
    }

    @ApiOperation("修改订阅")
    @PreAuthorize("@ss.hasPermi('business:subscribe:edit')")
    @Log(title = "订阅", businessType = BusinessType.UPDATE)
    @PostMapping("edit")
    public AjaxResult edit(@RequestBody FoxSubscribeVo entity) {
        return toAjax(foxSubscribeService.updateById(entity));
    }

    @ApiOperation("删除订阅")
    @PreAuthorize("@ss.hasPermi('business:subscribe:remove')")
    @Log(title = "订阅", businessType = BusinessType.DELETE)
	@GetMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(foxSubscribeService.removeByIds(Arrays.asList(ids)) ? 1 : 0);
    }
}
