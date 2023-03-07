package com.foxblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.foxblog.domain.ResponseResult;
import com.foxblog.domain.entity.Article;

public interface ArticleService extends IService<Article> {
    ResponseResult latestArticleList();
}
