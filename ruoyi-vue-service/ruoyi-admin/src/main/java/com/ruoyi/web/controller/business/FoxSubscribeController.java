package com.ruoyi.web.controller.business;

import com.ruoyi.business.domain.FoxArticle;
import com.ruoyi.business.domain.FoxSubscribe;
import com.ruoyi.business.service.IFoxSubscribeService;
import com.ruoyi.business.vo.FoxSubscribeVo;
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
 * 订阅Controller
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Api(tags = "订阅Controller")
@RestController
@RequestMapping("/business/subscribe")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FoxSubscribeController extends BaseController {

    private final IFoxSubscribeService foxSubscribeService;

    @ApiOperation("查询订阅列表")
    @PreAuthorize("@ss.hasPermi('business:subscribe:list')")
    @GetMapping("/list")
    public TableDataInfo list(@RequestParam Map<String, Object> params) {
        startPage();
        List<Map<String, Object>> list = foxSubscribeService.selectFoxSubscribeList(params);
        return getDataTable(list);
    }

    /**
     * 导出订阅列表
     */
//    @PreAuthorize("@ss.hasPermi('business:subscribe:export')")
//    @Log(title = "订阅", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    public void export(HttpServletResponse response, FoxSubscribe foxSubscribe) {
//        List<FoxSubscribe> list = foxSubscribeService.selectFoxSubscribeList(foxSubscribe);
//        ExcelUtil<FoxSubscribe> util =new ExcelUtil<FoxSubscribe>(FoxSubscribe.class);
//        util.exportExcel(response, list, "文章管理信息");
//    }

    /**
     * 获取订阅详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:subscribe:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(foxSubscribeService.selectFoxSubscribeById(id));
    }

    /**
     * 新增订阅
     */
    @PreAuthorize("@ss.hasPermi('business:subscribe:add')")
    @Log(title = "订阅", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FoxSubscribe foxSubscribe) {
        foxSubscribeService.insertFoxSubscribe(foxSubscribe);
        return AjaxResult.success();
    }

    /**
     * 修改订阅
     */
    @PreAuthorize("@ss.hasPermi('business:subscribe:edit')")
    @Log(title = "订阅", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FoxSubscribe foxSubscribe) {
        foxSubscribeService.updateFoxSubscribe(foxSubscribe);
        return AjaxResult.success();
    }

    /**
     * 删除订阅
     */
    @PreAuthorize("@ss.hasPermi('business:subscribe:remove')")
    @Log(title = "订阅", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        foxSubscribeService.deleteFoxSubscribeByIds(ids);
        return AjaxResult.success();
    }
}
