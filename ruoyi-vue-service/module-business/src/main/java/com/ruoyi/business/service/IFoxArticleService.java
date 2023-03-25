package com.ruoyi.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.business.domain.FoxArticle;
import com.ruoyi.business.vo.FoxArticleVo;

import java.util.List;

/**
 * 文章Service接口
 *
 * @author Foxx
 * @date 2023-03-25
 */
public interface IFoxArticleService extends IService<FoxArticle> {

    /**
     * 查询文章
     *
     * @param id 文章主键
     * @return 文章
     */
    public FoxArticle selectFoxArticleById(Long id);

    /**
     * 查询文章列表
     *
     * @param foxArticle 文章
     * @return 文章集合
     */
    public List<FoxArticle> selectFoxArticleList(FoxArticle foxArticle);

    /**
     * 新增文章
     *
     * @param foxArticle 文章
     */
    public void insertFoxArticle(FoxArticle foxArticle);

    /**
     * 修改文章
     *
     * @param foxArticle 文章
     */
    public void updateFoxArticle(FoxArticle foxArticle);

    /**
     * 批量删除文章
     *
     * @param ids 需要删除的文章主键集合
     */
    public void deleteFoxArticleByIds(Long[] ids);

    /**
     * 删除文章信息
     *
     * @param id 文章主键
     */
    public void deleteFoxArticleById(Long id);
}
