package my.words.news.service;

import my.words.news.RandomTitle;
import my.words.news.handler.AbstractNewsHandler;
import org.springframework.context.annotation.Configuration;

/**
 * User: Sushakov
 * Date: 12/13/2018
 * Time: 14:13
 **/
@Configuration("newYorkTimes")
public class NYTimes extends AbstractNewsHandler implements RandomTitle {

    private final static String JSON_ARRAY="results";
    private final static String JSON_FIELD="description";

    private final static String API_KEY="9c5f0436a2704d42805932d41a1281d7";
    private final static String API_URL = "http://api.nytimes.com/svc/topstories/v2/home.json?api-key="+API_KEY;

    @Override
    public String getTitle() {
        return getField(JSON_ARRAY,JSON_FIELD);
    }

    public NYTimes() {
        getJson(API_URL);
    }

}
