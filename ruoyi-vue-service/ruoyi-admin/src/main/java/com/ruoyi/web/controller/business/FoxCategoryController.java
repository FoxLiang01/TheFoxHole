package com.ruoyi.web.controller.business;

import com.ruoyi.business.domain.FoxArticle;
import com.ruoyi.business.domain.FoxCategory;
import com.ruoyi.business.service.IFoxCategoryService;
import com.ruoyi.business.vo.FoxCategoryVo;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

    /**
     * 查询合集列表
     */
    @PreAuthorize("@ss.hasPermi('blog:category:list')")
//    @ApiOperation("文章列表")
//    @ApiImplicitParams({@ApiImplicitParam(name = "foxArticle", value = "文章对象", dataType = "FoxArticle", dataTypeClass = FoxArticle.class)})
    @GetMapping("/list")
    public TableDataInfo list(@RequestParam Map<String, Object> params) {
        startPage();
        List<Map<String, Object>> list = foxCategoryService.selectFoxCategoryList(params);
        List<Map<String, Object>> resultList = foxCategoryService.getTreeList(list);
        return getDataTable(resultList);
    }

    /**
     * 导出合集列表
     */
    @PreAuthorize("@ss.hasPermi('blog:category:export')")
    @Log(title = "合集", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, @RequestParam Map<String, Object> params) {
//        List<Map<String, Object>> list = foxCategoryService.selectFoxCategoryList(params);
//        ExcelUtil<FoxCategory> util =new ExcelUtil<FoxCategory>(FoxCategory.class);
//        util.exportExcel(response, list, "合集管理信息");
    }

    /**
     * 获取合集详细信息
     */
    @PreAuthorize("@ss.hasPermi('blog:category:query')")
//    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "文章id", dataType = "Long", dataTypeClass = Long.class)})
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(foxCategoryService.selectFoxCategoryById(id));
    }

    /**
     * 新增合集
     */
    @PreAuthorize("@ss.hasPermi('blog:category:add')")
    @Log(title = "合集", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FoxCategory foxCategory) {
        foxCategoryService.insertFoxCategory(foxCategory);
        return AjaxResult.success();
    }

    /**
     * 修改合集
     */
    @PreAuthorize("@ss.hasPermi('blog:category:edit')")
    @Log(title = "合集", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FoxCategory foxCategory) {
        foxCategoryService.updateFoxCategory(foxCategory);
        return AjaxResult.success();
    }

    /**
     * 删除合集
     */
    @PreAuthorize("@ss.hasPermi('blog:category:remove')")
    @Log(title = "合集", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        foxCategoryService.deleteFoxCategoryByIds(ids);
        return AjaxResult.success();
    }
}
