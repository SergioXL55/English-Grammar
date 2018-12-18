package my.words.news.service;

import my.words.news.RandomTitle;
import my.words.news.handler.AbstractNewsHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * User: Sushakov
 * Date: 12/14/2018
 * Time: 12:52
 **/
@Configuration("googleNews")
@PropertySource("resources/googleNews.properties")
public class GoogleNews extends AbstractNewsHandler implements RandomTitle {

    @Value("${google.news.PARAM_SOURCE}")
    private String paramSource;
    @Value("${google.news.PARAM_FROM}")
    private String paramFrom;
    @Value("${google.news.API_KEY}")
    private String apiKey;
    @Value("${google.news.API_URL}")
    private String apiUrl;
    @Value("${google.news.JSON_ARRAY}")
    private String jsonArray;
    @Value("${google.news.JSON_FIELD}")
    private String jsonField;


    @Override
    public String getTitle() {
        String url=apiUrl+paramSource+paramFrom+getCurrentDate()+apiKey;
        getJson(url);
        return getField(jsonArray,jsonField);
    }

    public GoogleNews() {

    }

}
