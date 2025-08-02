package com.crus.NYTimes.controllers;

import com.crus.NYTimes.models.Article;
import com.crus.NYTimes.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NYTTestController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/nyt/test")
    public List<Article> getMostPopular() {
        return articleService.getMostPopular();
    }
}
