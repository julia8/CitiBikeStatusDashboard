package explore;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import util.ConfigHandler;
import util.IInputDataHandler;

import java.util.Set;

public class CitiBike {
    IInputDataHandler inputDataHandler;
    public CitiBike(IInputDataHandler inputDataHandler) {
        this.inputDataHandler = inputDataHandler;
    }

    public JsonElement getStatus(String whichSet) {

        JsonObject obj = inputDataHandler.getJsonFrom(ConfigHandler.getURL("citibike"));
        JsonElement r = obj.get("stationBeanList");
        Set<String> favoriteStations = ConfigHandler.getFavoriteStations(whichSet);

        JsonArray statusArray = new JsonArray();
        if(r.isJsonArray()) {
            JsonArray a = r.getAsJsonArray();
            for (JsonElement anA : a) {
                JsonObject next = anA.getAsJsonObject();
                String id = next.get("id").getAsString();
                if (favoriteStations.contains(id)) {
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
