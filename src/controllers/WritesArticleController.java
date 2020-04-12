package controllers;

import entity.WritesArticle;
import entity.WritesBook;
import services.WritesArticleService;

import java.util.ArrayList;
import java.util.List;

public class WritesArticleController {
    private WritesArticleService writesArticleService;

    public WritesArticleController(){
        this.writesArticleService = new WritesArticleService();
    }

    public List<Object> getArticlesByAuthor(String authorName){
        List<Object> writesArticles = writesArticleService.getArticlesByAuthor(authorName);
        List<Object> articles = new ArrayList<>();
        for(Object wb : writesArticles){
            articles.add(((WritesArticle)wb).getArticleTitle());
        }
        return articles;
    }
}