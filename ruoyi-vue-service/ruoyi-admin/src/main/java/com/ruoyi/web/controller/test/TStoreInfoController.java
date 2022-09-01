package com.ruoyi.web.controller.test;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.test.domain.TStoreInfo;
import com.ruoyi.test.service.ITStoreInfoService;
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
 * 门店Controller
 *
 * @author Tellsea
 * @date 2022-09-01
 */
@Api(tags = "门店Controller")
@RestController
@RequestMapping("/test/storeInfo")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TStoreInfoController extends BaseController {

    private final ITStoreInfoService tStoreInfoService;

    @ApiOperation("查询门店列表")
    @PreAuthorize("@ss.hasPermi('test:storeInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(TStoreInfo tStoreInfo) {
        return tStoreInfoService.queryList(tStoreInfo);
    }

    @ApiOperation("导出门店列表")
    @PreAuthorize("@ss.hasPermi('test:storeInfo:export')")
    @Log(title = "门店", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TStoreInfo tStoreInfo) {
        List<TStoreInfo> list = tStoreInfoService.queryAll(tStoreInfo);
        ExcelUtil<TStoreInfo> util = new ExcelUtil<>(TStoreInfo.class);
        util.exportExcel(response, list, "门店数据");
    }

    @ApiOperation("获取门店详细信息")
    @PreAuthorize("@ss.hasPermi('test:storeInfo:query')")
    @GetMapping(value = "/getInfo/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success("查询成功", tStoreInfoService.queryById(id));
    }

    @ApiOperation("新增门店")
    @PreAuthorize("@ss.hasPermi('test:storeInfo:add')")
    @Log(title = "门店", businessType = BusinessType.INSERT)
    @PostMapping("add")
    public AjaxResult add(@RequestBody TStoreInfo tStoreInfo) {
        return toAjax(tStoreInfoService.save(tStoreInfo));
    }

    @ApiOperation("修改门店")
    @PreAuthorize("@ss.hasPermi('test:storeInfo:edit')")
    @Log(title = "门店", businessType = BusinessType.UPDATE)
    @PostMapping("edit")
    public AjaxResult edit(@RequestBody TStoreInfo tStoreInfo) {
        return toAjax(tStoreInfoService.updateById(tStoreInfo));
    }

    @ApiOperation("删除门店")
    @PreAuthorize("@ss.hasPermi('test:storeInfo:remove')")
    @Log(title = "门店", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tStoreInfoService.removeByIds(Arrays.asList(ids)) ? 1 : 0);
    }
}
