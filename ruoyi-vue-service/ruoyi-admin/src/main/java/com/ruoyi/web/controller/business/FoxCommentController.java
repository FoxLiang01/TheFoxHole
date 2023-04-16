package com.ruoyi.web.controller.business;

import com.ruoyi.business.domain.FoxCategory;
import com.ruoyi.business.domain.FoxComment;
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
import java.util.Map;

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
    @PreAuthorize("@ss.hasPermi('blog:comment:list')")
    @GetMapping("/list")
    public TableDataInfo list(@RequestParam Map<String, Object> params) {
        startPage();
        List<Map<String, Object>> list = foxCommentService.selectFoxCommentList(params);
        return getDataTable(list);
    }

    /**
     * 导出评论列表
     */
//    @PreAuthorize("@ss.hasPermi('blog:comment:export')")
//    @Log(title = "评论", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    public void export(HttpServletResponse response, FoxComment foxComment) {
//        List<FoxComment> list = foxCommentService.selectFoxCommentList(foxComment);
//        ExcelUtil<FoxComment> util =new ExcelUtil<FoxComment>(FoxComment.class);
//        util.exportExcel(response, list, "合集管理信息");
//    }

    /**
     * 获取评论详细信息
     */
    @PreAuthorize("@ss.hasPermi('blog:comment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(foxCommentService.selectFoxCommentById(id));
    }

    /**
     * 新增评论
     */
    @PreAuthorize("@ss.hasPermi('blog:comment:add')")
    @Log(title = "评论", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FoxComment foxComment) {
        foxCommentService.insertFoxComment(foxComment);
        return AjaxResult.success();
    }

    /**
     * 修改评论
     */
    @PreAuthorize("@ss.hasPermi('blog:comment:edit')")
    @Log(title = "评论", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FoxComment foxComment) {
        foxCommentService.updateFoxComment(foxComment);
        return AjaxResult.success();
    }

    /**
     * 删除评论
     */
    @PreAuthorize("@ss.hasPermi('blog:comment:remove')")
    @Log(title = "评论", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        foxCommentService.deleteFoxCommentByIds(ids);
        return AjaxResult.success();
    }
}
