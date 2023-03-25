package com.ruoyi.web.controller.business;

import com.ruoyi.business.service.IFoxWorkService;
import com.ruoyi.business.vo.FoxWorkVo;
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
 * 连载文章Controller
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Api(tags = "连载文章Controller")
@RestController
@RequestMapping("/business/work")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FoxWorkController extends BaseController {

    private final IFoxWorkService foxWorkService;

    @ApiOperation("查询连载文章列表")
    @PreAuthorize("@ss.hasPermi('business:work:list')")
    @GetMapping("/list")
    public TableDataInfo<FoxWorkVo> list(FoxWorkVo entity) {
        return foxWorkService.queryList(entity);
    }

    @ApiOperation("查询连载文章所有列表")
    @GetMapping("/listAll")
    public AjaxResult listAll(FoxWorkVo entity) {
        return AjaxResult.success("查询成功", foxWorkService.queryAll(entity));
    }

    @ApiOperation("导出连载文章列表")
    @PreAuthorize("@ss.hasPermi('business:work:export')")
    @Log(title = "连载文章", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FoxWorkVo entity) {
        List<FoxWorkVo> list = foxWorkService.queryAll(entity);
        ExcelUtil<FoxWorkVo> util = new ExcelUtil<>(FoxWorkVo.class);
        util.exportExcel(response, list, "连载文章数据");
    }

    @ApiOperation("获取连载文章详细信息")
    @PreAuthorize("@ss.hasPermi('business:work:query')")
    @GetMapping(value = "/getInfo/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success("查询成功", foxWorkService.queryById(id));
    }

    @ApiOperation("新增连载文章")
    @PreAuthorize("@ss.hasPermi('business:work:add')")
    @Log(title = "连载文章", businessType = BusinessType.INSERT)
    @PostMapping("add")
    public AjaxResult add(@RequestBody FoxWorkVo entity) {
        return toAjax(foxWorkService.save(entity));
    }

    @ApiOperation("修改连载文章")
    @PreAuthorize("@ss.hasPermi('business:work:edit')")
    @Log(title = "连载文章", businessType = BusinessType.UPDATE)
    @PostMapping("edit")
    public AjaxResult edit(@RequestBody FoxWorkVo entity) {
        return toAjax(foxWorkService.updateById(entity));
    }

    @ApiOperation("删除连载文章")
    @PreAuthorize("@ss.hasPermi('business:work:remove')")
    @Log(title = "连载文章", businessType = BusinessType.DELETE)
	@GetMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(foxWorkService.removeByIds(Arrays.asList(ids)) ? 1 : 0);
    }
}
