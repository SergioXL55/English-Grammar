package my.words.news.service;

import my.words.news.RandomTitle;
import my.words.news.handler.AbstractNewsHandler;
import org.springframework.context.annotation.Configuration;

/**
 * User: Sushakov
 * Date: 12/14/2018
 * Time: 12:52
 **/
@Configuration("googleNews")
public class GoogleNews extends AbstractNewsHandler implements RandomTitle {

    private final static String JSON_ARRAY = "articles";
    private final static String JSON_FIELD = "title";
    private final static String API_KEY = "&apiKey=e25a8073d6d842b59c0d757c3a4736c0";
    private final static String PARAM_FROM = "&from=" + getCurrentDate();
    private final static String PARAM_SOURCE = "fox-news";
    private final static String API_URL = "http://newsapi.org/v2/everything?sources=" + PARAM_SOURCE + PARAM_FROM + API_KEY;

    @Override
    public String getTitle() {
        return getField(JSON_ARRAY, JSON_FIELD);
    }

    public GoogleNews() {
        getJson(API_URL);
    }


}
