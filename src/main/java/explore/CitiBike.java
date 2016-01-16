package explore;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import util.ConfigHandler;
import util.HttpHandler;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Julia on 1/15/2016.
 */
public class CitiBike {
    public static void main(String[] args) {
        System.out.println(getStatus().toString());
    }
    public static JsonElement getStatus() {

        JsonObject obj = HttpHandler.getJsonFromUrl(ConfigHandler.getURL("citibike"));
        JsonElement r = obj.get("results");
        Set<String> favoriteStations = ConfigHandler.getFavoriteStations();

        JsonArray statusArray = new JsonArray();
        if(r.isJsonArray()) {
            JsonArray a = r.getAsJsonArray();
            for(Iterator<JsonElement> it = a.iterator(); it.hasNext();) {
                JsonObject next = it.next().getAsJsonObject();
                String id = next.get("id").getAsString();
                if(favoriteStations.contains(id)) {
                    statusArray.add(next);
                }
            }

        }
        JsonObject faveStatus = new JsonObject();

        return statusArray;
    }
}
