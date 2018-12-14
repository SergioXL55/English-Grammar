package my.words.handler;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * User: Sushakov
 * Date: 12/14/2018
 * Time: 16:21
 **/

abstract class AbstractNewsHandler {

    private static final Logger LOG = Logger.getLogger(AbstractNewsHandler.class);

    private JsonObject jsonObject;
    private final static String dateFormate="yyyy-dd-MM";

    String getField(String jsonArrayName,String jsonFieldName) {
        JsonArray jsonArray = jsonObject.getAsJsonArray(jsonArrayName);
        if (jsonArray.size() > 0) {
            return jsonArray.get(new Random().nextInt(jsonArray.size())).getAsJsonObject().get(jsonFieldName).getAsString();
        }
        return "error";
    }

    void getJsonFromWeb(String url) {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            jsonObject = new JsonParser().parse(new Gson().newJsonReader(rd)).getAsJsonObject();
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }

    static String getCurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
        return sdf.format(new Date());
    }

}
