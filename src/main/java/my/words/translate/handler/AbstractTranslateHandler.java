package my.words.translate.handler;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import my.words.json.handler.JsonHandler;

/**
 * User: Sushakov
 * Date: 12/17/2018
 * Time: 10:55
 **/

public class AbstractTranslateHandler extends JsonHandler {

    private JsonObject jsonObject;

    protected String getField(String jsonArrayName) {
        JsonArray jsonArray = jsonObject.getAsJsonArray(jsonArrayName);
        return jsonArray.get(0).getAsString();
    }

    @Override
    public void getJson(String url) {
        this.jsonObject = getJsonFromWeb(url);
    }
}
