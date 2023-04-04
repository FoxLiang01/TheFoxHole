package com.ruoyi.web.controller.business;

import com.ruoyi.business.domain.FoxArticle;
import com.ruoyi.business.service.IFoxArticleService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import io.swagger.annotations.Api;
import org.apiguardian.api.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 文章Controller
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Api(tags = "文章Article")
@RestController
@RequestMapping("/business/article")
public class FoxArticleController extends BaseController {

    @Autowired
    private IFoxArticleService foxArticleService;

    /**
     * 查询文章列表
     */
    @PreAuthorize("@ss.hasPermi('blog:article:list')")
    @GetMapping("/list")
    public TableDataInfo list(FoxArticle foxArticle)
    {
        startPage();
        List<FoxArticle> list = foxArticleService.selectFoxArticleList(foxArticle);
        return getDataTable(list);
    }

    /**
     * 导出文章列表
     */
    @PreAuthorize("@ss.hasPermi('blog:article:export')")
    @Log(title = "文章", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FoxArticle foxArticle)
    {
        List<FoxArticle> list = foxArticleService.selectFoxArticleList(foxArticle);
        ExcelUtil<FoxArticle> util =new ExcelUtil<FoxArticle>(FoxArticle.class);
        util.exportExcel(response, list, "文章管理信息");
    }

    /**
     * 获取文章详细信息
     */
    @PreAuthorize("@ss.hasPermi('blog:article:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(foxArticleService.selectFoxArticleById(id));
    }

    /**
     * 新增文章
     */
    @PreAuthorize("@ss.hasPermi('blog:article:add')")
    @Log(title = "文章", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FoxArticle foxArticle)
    {
        foxArticleService.insertFoxArticle(foxArticle);
        return AjaxResult.success();
    }

    /**
     * 修改文章
     */
    @PreAuthorize("@ss.hasPermi('blog:article:edit')")
    @Log(title = "文章", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FoxArticle foxArticle)
    {
        foxArticleService.updateFoxArticle(foxArticle);
        return AjaxResult.success();
    }

    /**
     * 删除文章
     */
    @PreAuthorize("@ss.hasPermi('blog:article:remove')")
    @Log(title = "文章", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        foxArticleService.deleteFoxArticleByIds(ids);
        return AjaxResult.success();
    }
}
