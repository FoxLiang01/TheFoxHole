package com.ruoyi.business.controller;

import com.ruoyi.business.service.ITTestInfoService;
import com.ruoyi.business.vo.TTestInfoVo;
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
 * 测试Controller
 *
 * @author Tellsea
 * @date 2022-09-02
 */
@Api(tags = "测试Controller")
@RestController
@RequestMapping("/business/testInfo")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TTestInfoController extends BaseController {

    private final ITTestInfoService tTestInfoService;

    @ApiOperation("查询测试列表")
    @PreAuthorize("@ss.hasPermi('business:testInfo:list')")
    @GetMapping("/list")
    public TableDataInfo<TTestInfoVo> list(TTestInfoVo entity) {
        return tTestInfoService.queryList(entity);
    }

    @ApiOperation("查询测试所有列表")
    @GetMapping("/listAll")
    public AjaxResult listAll(TTestInfoVo entity) {
        return AjaxResult.success("查询成功", tTestInfoService.queryAll(entity));
    }

    @ApiOperation("导出测试列表")
    @PreAuthorize("@ss.hasPermi('business:testInfo:export')")
    @Log(title = "测试", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TTestInfoVo entity) {
        List<TTestInfoVo> list = tTestInfoService.queryAll(entity);
        ExcelUtil<TTestInfoVo> util = new ExcelUtil<>(TTestInfoVo.class);
        util.exportExcel(response, list, "测试数据");
    }

    @ApiOperation("获取测试详细信息")
    @PreAuthorize("@ss.hasPermi('business:testInfo:query')")
    @GetMapping(value = "/getInfo/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success("查询成功", tTestInfoService.queryById(id));
    }

    @ApiOperation("新增测试")
    @PreAuthorize("@ss.hasPermi('business:testInfo:add')")
    @Log(title = "测试", businessType = BusinessType.INSERT)
    @PostMapping("add")
    public AjaxResult add(@RequestBody TTestInfoVo entity) {
        return toAjax(tTestInfoService.save(entity));
    }

    @ApiOperation("修改测试")
    @PreAuthorize("@ss.hasPermi('business:testInfo:edit')")
    @Log(title = "测试", businessType = BusinessType.UPDATE)
    @PostMapping("edit")
    public AjaxResult edit(@RequestBody TTestInfoVo entity) {
        return toAjax(tTestInfoService.updateById(entity));
    }

    @ApiOperation("删除测试")
    @PreAuthorize("@ss.hasPermi('business:testInfo:remove')")
    @Log(title = "测试", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tTestInfoService.removeByIds(Arrays.asList(ids)) ? 1 : 0);
    }
}
