package com.ruoyi.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.business.domain.FoxArticle;
import com.ruoyi.business.mapper.FoxArticleMapper;
import com.ruoyi.business.service.IFoxArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章Service业务层处理
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Service
public class FoxArticleServiceImpl extends ServiceImpl<FoxArticleMapper, FoxArticle> implements IFoxArticleService {

    @Autowired
    private FoxArticleMapper foxArticleMapper;

    /**
     * 查询文章
     *
     * @param id 文章主键
     * @return 文章
     */
    @Override
    public FoxArticle selectFoxArticleById(Long id)
    {
        return foxArticleMapper.selectFoxArticleById(id);
    }

    /**
     * 查询文章列表
     *
     * @param foxArticle 文章
     * @return 文章
     */
    @Override
    public List<FoxArticle> selectFoxArticleList(FoxArticle foxArticle)
    {
        return foxArticleMapper.selectFoxArticleList(foxArticle);
    }

    /**
     * 新增文章
     *
     * @param foxArticle 文章
     * @return 结果
     */
    @Override
    public void insertFoxArticle(FoxArticle foxArticle)
    {
        this.save(foxArticle);
    }

    /**
     * 修改文章
     *
     * @param foxArticle 文章
     */
    @Override
    public void updateFoxArticle(FoxArticle foxArticle)
    {
//        List<FoxArticle> list =this.list(newQueryWrapper<FoxArticle>()
//                .eq("del_flag","0").eq("partner_name",foxArticle.getPartnerName()));
//        if(list.size() > 0 ) {
//            throw newServiceException("该合作方已存在！");
//        }
        this.updateById(foxArticle);
    }

    /**
     * 批量删除文章
     *
     * @param ids 需要删除的文章主键
     * @return 结果
     */
    @Override
    public void deleteFoxArticleByIds(Long[] ids)
    {
        UpdateWrapper<FoxArticle> updateWrapper =new UpdateWrapper();
        updateWrapper.eq("id", ids);
        updateWrapper.eq("del_flag", "0");
        updateWrapper.set("del_flag", "2");
        this.update(updateWrapper);
    }

    /**
     * 删除文章信息
     *
     * @param id 文章主键
     * @return 结果
     */
    @Override
    public void deleteFoxArticleById(Long id)
    {
        UpdateWrapper<FoxArticle> updateWrapper =new UpdateWrapper();
        updateWrapper.eq("id", id);
        updateWrapper.eq("del_flag", "0");
        updateWrapper.set("del_flag", "2");
        this.update(updateWrapper);
    }
}
