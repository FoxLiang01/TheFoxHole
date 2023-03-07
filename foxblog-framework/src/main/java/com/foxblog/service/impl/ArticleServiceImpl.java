package com.foxblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.foxblog.domain.ResponseResult;
import com.foxblog.domain.entity.Article;
import com.foxblog.mapper.ArticleMapper;
import com.foxblog.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public ResponseResult<Article> latestArticleList() {
        //查询最新发表的文章，封装成ResponseResult返回
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
//        查询条件：必须是已发表文章(方法引用的名字，值)
//        queryWrapper.eq(Article::getStatus,0);
//        按照发表时间进行排序
//        queryWrapper.orderByAsc();
//        最多只能查10条消息

//        page();
        return null;
    }
}
