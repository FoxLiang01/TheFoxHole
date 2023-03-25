package com.ruoyi.web.controller.business;

import com.ruoyi.business.service.IFoxArticleTagService;
import com.ruoyi.business.vo.FoxArticleTagVo;
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
 * 文章与标题的关联Controller
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Api(tags = "文章与标题的关联Controller")
@RestController
@RequestMapping("/business/articleTag")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FoxArticleTagController extends BaseController {

    private final IFoxArticleTagService foxArticleTagService;

    @ApiOperation("查询文章与标题的关联列表")
    @PreAuthorize("@ss.hasPermi('business:articleTag:list')")
    @GetMapping("/list")
    public TableDataInfo<FoxArticleTagVo> list(FoxArticleTagVo entity) {
        return foxArticleTagService.queryList(entity);
    }

    @ApiOperation("查询文章与标题的关联所有列表")
    @GetMapping("/listAll")
    public AjaxResult listAll(FoxArticleTagVo entity) {
        return AjaxResult.success("查询成功", foxArticleTagService.queryAll(entity));
    }

    @ApiOperation("导出文章与标题的关联列表")
    @PreAuthorize("@ss.hasPermi('business:articleTag:export')")
    @Log(title = "文章与标题的关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FoxArticleTagVo entity) {
        List<FoxArticleTagVo> list = foxArticleTagService.queryAll(entity);
        ExcelUtil<FoxArticleTagVo> util = new ExcelUtil<>(FoxArticleTagVo.class);
        util.exportExcel(response, list, "文章与标题的关联数据");
    }

    @ApiOperation("获取文章与标题的关联详细信息")
    @PreAuthorize("@ss.hasPermi('business:articleTag:query')")
    @GetMapping(value = "/getInfo/{articleId}")
    public AjaxResult getInfo(@PathVariable("articleId") Long articleId) {
        return AjaxResult.success("查询成功", foxArticleTagService.queryById(articleId));
    }

    @ApiOperation("新增文章与标题的关联")
    @PreAuthorize("@ss.hasPermi('business:articleTag:add')")
    @Log(title = "文章与标题的关联", businessType = BusinessType.INSERT)
    @PostMapping("add")
    public AjaxResult add(@RequestBody FoxArticleTagVo entity) {
        return toAjax(foxArticleTagService.save(entity));
    }

    @ApiOperation("修改文章与标题的关联")
    @PreAuthorize("@ss.hasPermi('business:articleTag:edit')")
    @Log(title = "文章与标题的关联", businessType = BusinessType.UPDATE)
    @PostMapping("edit")
    public AjaxResult edit(@RequestBody FoxArticleTagVo entity) {
        return toAjax(foxArticleTagService.updateById(entity));
    }

    @ApiOperation("删除文章与标题的关联")
    @PreAuthorize("@ss.hasPermi('business:articleTag:remove')")
    @Log(title = "文章与标题的关联", businessType = BusinessType.DELETE)
	@GetMapping("/remove/{articleIds}")
    public AjaxResult remove(@PathVariable Long[] articleIds) {
        return toAjax(foxArticleTagService.removeByIds(Arrays.asList(articleIds)) ? 1 : 0);
    }
}
