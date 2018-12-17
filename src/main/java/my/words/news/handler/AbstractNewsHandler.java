package my.words.news.handler;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import my.words.json.handler.JsonHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * User: Sushakov
 * Date: 12/14/2018
 * Time: 16:21
 **/

public abstract class AbstractNewsHandler extends JsonHandler {

    private JsonObject jsonObject;
    private final static String dateFormate = "yyyy-dd-MM";

    protected String getField(String jsonArrayName, String jsonFieldName) {
        JsonArray jsonArray = jsonObject.getAsJsonArray(jsonArrayName);
        if (jsonArray.size() > 0) {
            return jsonArray.get(new Random().nextInt(jsonArray.size())).getAsJsonObject().get(jsonFieldName).getAsString();
        }
        return "error";
    }

    protected static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
        return sdf.format(new Date());
    }

    @Override
    public void getJson(String url) {
        this.jsonObject = getJsonFromWeb(url);
    }
}
