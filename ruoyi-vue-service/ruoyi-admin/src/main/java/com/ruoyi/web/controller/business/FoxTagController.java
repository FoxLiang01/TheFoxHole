package com.ruoyi.web.controller.business;

import com.ruoyi.business.service.IFoxTagService;
import com.ruoyi.business.vo.FoxTagVo;
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
 * 标签Controller
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Api(tags = "标签Controller")
@RestController
@RequestMapping("/business/tag")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FoxTagController extends BaseController {

    private final IFoxTagService foxTagService;

    @ApiOperation("查询标签列表")
    @PreAuthorize("@ss.hasPermi('business:tag:list')")
    @GetMapping("/list")
    public TableDataInfo<FoxTagVo> list(FoxTagVo entity) {
        return foxTagService.queryList(entity);
    }

    @ApiOperation("查询标签所有列表")
    @GetMapping("/listAll")
    public AjaxResult listAll(FoxTagVo entity) {
        return AjaxResult.success("查询成功", foxTagService.queryAll(entity));
    }

    @ApiOperation("导出标签列表")
    @PreAuthorize("@ss.hasPermi('business:tag:export')")
    @Log(title = "标签", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FoxTagVo entity) {
        List<FoxTagVo> list = foxTagService.queryAll(entity);
        ExcelUtil<FoxTagVo> util = new ExcelUtil<>(FoxTagVo.class);
        util.exportExcel(response, list, "标签数据");
    }

    @ApiOperation("获取标签详细信息")
    @PreAuthorize("@ss.hasPermi('business:tag:query')")
    @GetMapping(value = "/getInfo/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success("查询成功", foxTagService.queryById(id));
    }

    @ApiOperation("新增标签")
    @PreAuthorize("@ss.hasPermi('business:tag:add')")
    @Log(title = "标签", businessType = BusinessType.INSERT)
    @PostMapping("add")
    public AjaxResult add(@RequestBody FoxTagVo entity) {
        return toAjax(foxTagService.save(entity));
    }

    @ApiOperation("修改标签")
    @PreAuthorize("@ss.hasPermi('business:tag:edit')")
    @Log(title = "标签", businessType = BusinessType.UPDATE)
    @PostMapping("edit")
    public AjaxResult edit(@RequestBody FoxTagVo entity) {
        return toAjax(foxTagService.updateById(entity));
    }

    @ApiOperation("删除标签")
    @PreAuthorize("@ss.hasPermi('business:tag:remove')")
    @Log(title = "标签", businessType = BusinessType.DELETE)
	@GetMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(foxTagService.removeByIds(Arrays.asList(ids)) ? 1 : 0);
    }
}
