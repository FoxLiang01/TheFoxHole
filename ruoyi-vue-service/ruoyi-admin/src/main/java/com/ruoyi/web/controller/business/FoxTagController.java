package com.ruoyi.web.controller.business;

import com.ruoyi.business.domain.FoxArticle;
import com.ruoyi.business.domain.FoxTag;
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
import java.util.Map;

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

    /**
     * 查询标签列表
     */
    @PreAuthorize("@ss.hasPermi('blog:tag:list')")
    @GetMapping("/list")
    public TableDataInfo list(Map<String, Object> params) {
        startPage();
        List<Map<String, Object>> list = foxTagService.selectFoxTagList(params);
        return getDataTable(list);
    }

    /**
     * 导出标签列表
     */
//    @PreAuthorize("@ss.hasPermi('blog:tag:export')")
//    @Log(title = "标签", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    public void export(HttpServletResponse response, FoxTag foxTag) {
//        List<FoxTag> list = foxTagService.selectFoxTagList(foxTag);
//        ExcelUtil<FoxTag> util =new ExcelUtil<FoxTag>(FoxTag.class);
//        util.exportExcel(response, list, "文章管理信息");
//    }

    /**
     * 获取标签详细信息
     */
    @PreAuthorize("@ss.hasPermi('blog:tag:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(foxTagService.selectFoxTagById(id));
    }

    /**
     * 新增标签
     */
    @PreAuthorize("@ss.hasPermi('blog:tag:add')")
    @Log(title = "标签", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FoxTag foxTag) {
        foxTagService.insertFoxTag(foxTag);
        return AjaxResult.success();
    }

    /**
     * 修改标签
     */
    @PreAuthorize("@ss.hasPermi('blog:tag:edit')")
    @Log(title = "标签", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FoxTag foxTag) {
        foxTagService.updateFoxTag(foxTag);
        return AjaxResult.success();
    }

    /**
     * 删除标签
     */
    @PreAuthorize("@ss.hasPermi('blog:tag:remove')")
    @Log(title = "标签", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        foxTagService.deleteFoxTagByIds(ids);
        return AjaxResult.success();
    }
}
