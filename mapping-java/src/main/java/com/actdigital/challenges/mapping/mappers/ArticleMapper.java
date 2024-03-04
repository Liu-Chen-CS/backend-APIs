package com.actdigital.challenges.mapping.mappers;

import com.actdigital.challenges.mapping.models.db.Article;
import com.actdigital.challenges.mapping.models.db.blocks.*;
import com.actdigital.challenges.mapping.models.dto.ArticleDto;
import com.actdigital.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ArticleMapper {
    public ArticleDto map(Article article){
        //TODO
        ArticleDto articleDto = new ArticleDto();
        List<ArticleBlockDto> list = new ArrayList<>();

        articleDto.setId(article.getId());
        articleDto.setTitle(article.getTitle());
        articleDto.setDescription(article.getDescription());
        articleDto.setAuthor(article.getAuthor());

        for (ArticleBlock block : article.getBlocks()) {
            if(block instanceof GalleryBlock || block instanceof ImageBlock || block instanceof TextBlock || block instanceof VideoBlock){
                ArticleBlockDto articleBlockDto = new ArticleBlockDto();
                articleBlockDto.setSortIndex(block.getSortIndex());
                list.add(articleBlockDto);
            }
            else{
                System.out.println(new Date() + " New implementation of ArticleBlock is detected " + block.getClass().getSimpleName());
                ArticleBlockDto articleBlockDto = new ArticleBlockDto();
                articleBlockDto.setSortIndex(block.getSortIndex());
                list.add(articleBlockDto);
            }
        }
        Collections.sort(list, helper());
        articleDto.setBlocks(list);

        return articleDto;
    }

    public Article map(ArticleDto articleDto) {
        // Nicht Teil dieser Challenge.
        return new Article();
    }

/*
    The subtraction to compare two numerical value might lead to incorrect result,
    therefore it's better to use compareTo()
    For more info, see example below:
    https://stackoverflow.com/questions/2728793/java-integer-compareto-why-use-comparison-vs-subtraction
*/
    private Comparator helper(){
        Comparator<ArticleBlockDto> comparator = new Comparator<ArticleBlockDto>() {
            @Override
            public int compare(ArticleBlockDto t2, ArticleBlockDto t1) {
                return (Integer.valueOf(t1.getSortIndex()).compareTo(Integer.valueOf(t2.getSortIndex())));
            }
        };
        return comparator;
    }
}
