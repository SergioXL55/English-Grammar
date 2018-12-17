package my.words.json.handler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * User: Sushakov
 * Date: 12/17/2018
 * Time: 10:11
 **/

public abstract class JsonHandler {

    private static final Logger LOG = Logger.getLogger(JsonHandler.class);

    public abstract void getJson(String url);

    protected JsonObject getJsonFromWeb(String url) {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            return new JsonParser().parse(new Gson().newJsonReader(rd)).getAsJsonObject();
        } catch (IOException e) {
            LOG.error(e.getMessage());
            return null;
        }
    }

}
