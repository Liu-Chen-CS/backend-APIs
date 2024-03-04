package com.actdigital.challenges.mapping.services;

import com.actdigital.challenges.mapping.mappers.ArticleMapper;
import com.actdigital.challenges.mapping.models.db.Article;
import com.actdigital.challenges.mapping.models.db.blocks.ArticleBlock;
import com.actdigital.challenges.mapping.models.dto.ArticleDto;
import com.actdigital.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import com.actdigital.challenges.mapping.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticleService {

    private final ArticleRepository repository;

    private final ArticleMapper mapper;

    @Autowired
    public ArticleService(ArticleRepository repository, ArticleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ArticleDto> list() {
        final List<Article> articles = repository.all();
        //TODO
        final List<ArticleDto> articleDtos = new ArrayList<>();
        for(Article article : articles){
            ArticleDto articleDto = mapper.map(article);
            articleDtos.add(articleDto);
        }
        return articleDtos;
    }

    public ArticleDto articleForId(Long id) {
        final Article article = repository.findBy(id);
        //TODO
        if(article != null){
            ArticleDto articleDto = mapper.map(article);
            return articleDto;
        }
        else{
            return null;
        }
    }

    public ArticleDto create(ArticleDto articleDto) {
        final Article create = mapper.map(articleDto);
        repository.create(create);
        return mapper.map(create);
    }
}
