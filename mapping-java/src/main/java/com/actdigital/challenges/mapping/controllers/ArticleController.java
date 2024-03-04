package com.actdigital.challenges.mapping.controllers;

import com.actdigital.challenges.mapping.models.db.Article;
import com.actdigital.challenges.mapping.models.dto.ArticleDto;
import com.actdigital.challenges.mapping.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping()
    public List<ArticleDto> list() {
        return articleService.list();
    }

    @GetMapping("/{id}")
    public ArticleDto details(@PathVariable Long id) {
        ArticleDto articleDto = articleService.articleForId(id);
        if(articleDto != null) return articleDto;
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article was not found with this id: " + id);
    }

    @PostMapping()
    public ArticleDto create(@RequestBody ArticleDto articleDto) {
        return articleService.create(articleDto);
    }
}
