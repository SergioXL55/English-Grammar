package my.words.translate.services;

import my.words.translate.Translator;
import my.words.translate.handler.AbstractTranslateHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * User: Sushakov
 * Date: 12/17/2018
 * Time: 10:05
 **/
@Configuration
@PropertySource("resources/yandexTranslator.properties")
public class YandexTranslator extends AbstractTranslateHandler implements Translator {

    @Value("${ya.trans.JSON_ARRAY}")
    private String jsonArray;
    @Value("${ya.trans.API_KEY}")
    private String apiKey;
    @Value("${ya.trans.PARAM_TEXT}")
    private String paramText;
    @Value("${ya.trans.PARAM_LANG}")
    private String paramLang;
    @Value("${ya.trans.API_URL}")
    private String apiUrl;
    @Value("${ya.trans.YANDEX_API}")
    private String yandexApi;

    @Override
    public String getTranslate(String inputText) {
        String url = apiUrl + apiKey + paramLang + paramText;
        getJson(url + inputText);
        return "Перевод: " + getField(jsonArray) + yandexApi;
    }
}
