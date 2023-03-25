package com.ruoyi.web.controller.business;

import com.ruoyi.business.service.IFoxCategoryService;
import com.ruoyi.business.vo.FoxCategoryVo;
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
 * 合集Controller
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Api(tags = "合集Controller")
@RestController
@RequestMapping("/business/category")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FoxCategoryController extends BaseController {

    private final IFoxCategoryService foxCategoryService;

    @ApiOperation("查询合集列表")
    @PreAuthorize("@ss.hasPermi('business:category:list')")
    @GetMapping("/list")
    public TableDataInfo<FoxCategoryVo> list(FoxCategoryVo entity) {
        return foxCategoryService.queryList(entity);
    }

    @ApiOperation("查询合集所有列表")
    @GetMapping("/listAll")
    public AjaxResult listAll(FoxCategoryVo entity) {
        return AjaxResult.success("查询成功", foxCategoryService.queryAll(entity));
    }

    @ApiOperation("导出合集列表")
    @PreAuthorize("@ss.hasPermi('business:category:export')")
    @Log(title = "合集", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FoxCategoryVo entity) {
        List<FoxCategoryVo> list = foxCategoryService.queryAll(entity);
        ExcelUtil<FoxCategoryVo> util = new ExcelUtil<>(FoxCategoryVo.class);
        util.exportExcel(response, list, "合集数据");
    }

    @ApiOperation("获取合集详细信息")
    @PreAuthorize("@ss.hasPermi('business:category:query')")
    @GetMapping(value = "/getInfo/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success("查询成功", foxCategoryService.queryById(id));
    }

    @ApiOperation("新增合集")
    @PreAuthorize("@ss.hasPermi('business:category:add')")
    @Log(title = "合集", businessType = BusinessType.INSERT)
    @PostMapping("add")
    public AjaxResult add(@RequestBody FoxCategoryVo entity) {
        return toAjax(foxCategoryService.save(entity));
    }

    @ApiOperation("修改合集")
    @PreAuthorize("@ss.hasPermi('business:category:edit')")
    @Log(title = "合集", businessType = BusinessType.UPDATE)
    @PostMapping("edit")
    public AjaxResult edit(@RequestBody FoxCategoryVo entity) {
        return toAjax(foxCategoryService.updateById(entity));
    }

    @ApiOperation("删除合集")
    @PreAuthorize("@ss.hasPermi('business:category:remove')")
    @Log(title = "合集", businessType = BusinessType.DELETE)
	@GetMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(foxCategoryService.removeByIds(Arrays.asList(ids)) ? 1 : 0);
    }
}
