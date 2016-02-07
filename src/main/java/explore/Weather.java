package explore;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import explore.data.darksky.Forecast;
import explore.data.WeatherConditions;
import util.ConfigHandler;
import util.IInputDataHandler;

public class Weather {
    IInputDataHandler inputDataHandler;

    public Weather(IInputDataHandler inputDataHandler) {
        this.inputDataHandler = inputDataHandler;
    }


    public JsonElement getCurrentConditions() {
        String url = ConfigHandler.getURL("weather");

        Forecast obj = (Forecast)inputDataHandler.getObjectFrom(url, new Forecast());
        WeatherConditions conditions = new WeatherConditions();
        conditions.setCurrentTemp(Float.toString(obj.getCurrently().getTemperature()));
        conditions.setSummary(obj.getCurrently().getSummary());
        Gson gson = new Gson();
        return gson.toJsonTree(conditions);
    }

}
