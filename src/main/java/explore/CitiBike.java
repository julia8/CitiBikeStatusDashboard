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
        System.out.println(getStatus("default").toString());
    }

    public static JsonElement getStatus(String whichSet) {

        JsonObject obj = HttpHandler.getJsonFromUrl(ConfigHandler.getURL("citibike"));
        JsonElement r = obj.get("stationBeanList");
        Set<String> favoriteStations = ConfigHandler.getFavoriteStations(whichSet);

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
        JsonObject records = new JsonObject();
        records.add("records", statusArray);
        return records;
    }
}
