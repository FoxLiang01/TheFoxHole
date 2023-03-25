package com.ruoyi.web.controller.business;

import com.ruoyi.business.service.IFoxCommentService;
import com.ruoyi.business.vo.FoxCommentVo;
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
 * 评论Controller
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Api(tags = "评论Controller")
@RestController
@RequestMapping("/business/comment")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FoxCommentController extends BaseController {

    private final IFoxCommentService foxCommentService;

    @ApiOperation("查询评论列表")
    @PreAuthorize("@ss.hasPermi('business:comment:list')")
    @GetMapping("/list")
    public TableDataInfo<FoxCommentVo> list(FoxCommentVo entity) {
        return foxCommentService.queryList(entity);
    }

    @ApiOperation("查询评论所有列表")
    @GetMapping("/listAll")
    public AjaxResult listAll(FoxCommentVo entity) {
        return AjaxResult.success("查询成功", foxCommentService.queryAll(entity));
    }

    @ApiOperation("导出评论列表")
    @PreAuthorize("@ss.hasPermi('business:comment:export')")
    @Log(title = "评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FoxCommentVo entity) {
        List<FoxCommentVo> list = foxCommentService.queryAll(entity);
        ExcelUtil<FoxCommentVo> util = new ExcelUtil<>(FoxCommentVo.class);
        util.exportExcel(response, list, "评论数据");
    }

    @ApiOperation("获取评论详细信息")
    @PreAuthorize("@ss.hasPermi('business:comment:query')")
    @GetMapping(value = "/getInfo/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success("查询成功", foxCommentService.queryById(id));
    }

    @ApiOperation("新增评论")
    @PreAuthorize("@ss.hasPermi('business:comment:add')")
    @Log(title = "评论", businessType = BusinessType.INSERT)
    @PostMapping("add")
    public AjaxResult add(@RequestBody FoxCommentVo entity) {
        return toAjax(foxCommentService.save(entity));
    }

    @ApiOperation("修改评论")
    @PreAuthorize("@ss.hasPermi('business:comment:edit')")
    @Log(title = "评论", businessType = BusinessType.UPDATE)
    @PostMapping("edit")
    public AjaxResult edit(@RequestBody FoxCommentVo entity) {
        return toAjax(foxCommentService.updateById(entity));
    }

    @ApiOperation("删除评论")
    @PreAuthorize("@ss.hasPermi('business:comment:remove')")
    @Log(title = "评论", businessType = BusinessType.DELETE)
	@GetMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(foxCommentService.removeByIds(Arrays.asList(ids)) ? 1 : 0);
    }
}
