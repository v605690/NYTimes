package com.crus.NYTimes.controllers;

import com.crus.NYTimes.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("articleList", articleService.getMostPopular());
        return "index";
    }

    @GetMapping("/search")
    public String searchNYT(Model model) {
        return "search";
    }

    @PostMapping("/search")
    public String postNYT(@RequestParam("searchText") String searchText, Model model) {
        model.addAttribute("searchResults", articleService.getSearchResults(searchText));
        model.addAttribute("searchQuery", searchText);
            return "search-results";
    }
}
