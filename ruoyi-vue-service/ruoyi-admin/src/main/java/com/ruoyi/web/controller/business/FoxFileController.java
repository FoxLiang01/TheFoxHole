package com.ruoyi.web.controller.business;

import com.ruoyi.business.service.IFoxFileService;
import com.ruoyi.business.vo.FoxFileVo;
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
 * 文件Controller
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Api(tags = "文件Controller")
@RestController
@RequestMapping("/business/file")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FoxFileController extends BaseController {

    private final IFoxFileService foxFileService;

    @ApiOperation("查询文件列表")
    @PreAuthorize("@ss.hasPermi('business:file:list')")
    @GetMapping("/list")
    public TableDataInfo<FoxFileVo> list(FoxFileVo entity) {
        return foxFileService.queryList(entity);
    }

    @ApiOperation("查询文件所有列表")
    @GetMapping("/listAll")
    public AjaxResult listAll(FoxFileVo entity) {
        return AjaxResult.success("查询成功", foxFileService.queryAll(entity));
    }

    @ApiOperation("导出文件列表")
    @PreAuthorize("@ss.hasPermi('business:file:export')")
    @Log(title = "文件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FoxFileVo entity) {
        List<FoxFileVo> list = foxFileService.queryAll(entity);
        ExcelUtil<FoxFileVo> util = new ExcelUtil<>(FoxFileVo.class);
        util.exportExcel(response, list, "文件数据");
    }

    @ApiOperation("获取文件详细信息")
    @PreAuthorize("@ss.hasPermi('business:file:query')")
    @GetMapping(value = "/getInfo/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success("查询成功", foxFileService.queryById(id));
    }

    @ApiOperation("新增文件")
    @PreAuthorize("@ss.hasPermi('business:file:add')")
    @Log(title = "文件", businessType = BusinessType.INSERT)
    @PostMapping("add")
    public AjaxResult add(@RequestBody FoxFileVo entity) {
        return toAjax(foxFileService.save(entity));
    }

    @ApiOperation("修改文件")
    @PreAuthorize("@ss.hasPermi('business:file:edit')")
    @Log(title = "文件", businessType = BusinessType.UPDATE)
    @PostMapping("edit")
    public AjaxResult edit(@RequestBody FoxFileVo entity) {
        return toAjax(foxFileService.updateById(entity));
    }

    @ApiOperation("删除文件")
    @PreAuthorize("@ss.hasPermi('business:file:remove')")
    @Log(title = "文件", businessType = BusinessType.DELETE)
	@GetMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(foxFileService.removeByIds(Arrays.asList(ids)) ? 1 : 0);
    }
}
