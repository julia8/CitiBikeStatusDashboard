package explore;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import util.ConfigHandler;
import util.HttpHandler;

public class Weather {
    public static JsonElement getCurrentConditions() {
        JsonObject obj = HttpHandler.getJsonFromUrl(ConfigHandler.getURL("weather"));
        return obj.get("currently");
    }

}
