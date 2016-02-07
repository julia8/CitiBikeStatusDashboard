package explore;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import util.ConfigHandler;
import util.IInputDataHandler;

public class Weather {
    IInputDataHandler inputDataHandler;

    public Weather(IInputDataHandler inputDataHandler) {
        this.inputDataHandler = inputDataHandler;
    }


    public JsonElement getCurrentConditions() {
        String url = ConfigHandler.getURL("weather");
        System.out.println(url);
        JsonObject obj = inputDataHandler.getJsonFrom(url);
        return obj.get("currently");
    }

}
