package com.foxblog.controller;

import com.foxblog.domain.ResponseResult;
import com.foxblog.domain.entity.Article;
import com.foxblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

//    @GetMapping("/list")
//    public List<Article> test(){
//        return articleService.list();
//    }

    @GetMapping("/latestArticleList")
    public ResponseResult latestArticleList(){
//        查询最新发表的文章，封装成ResponseResult返回
        ResponseResult result =  articleService.latestArticleList();
        return result;
    }
}
