package explore;

import com.google.gson.*;
import explore.data.WeatherHourly;
import explore.data.darksky.Data;
import explore.data.darksky.Details;
import explore.data.darksky.Forecast;
import explore.data.WeatherConditions;
import util.ConfigHandler;
import util.IInputDataHandler;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Weather {
    private IInputDataHandler inputDataHandler;
    private Forecast forecast;

    public Weather(IInputDataHandler inputDataHandler) {
        this.inputDataHandler = inputDataHandler;
        String url = ConfigHandler.getURL("weather");
        forecast = (Forecast)inputDataHandler.getObjectFrom(url, new Forecast());
    }

    public JsonElement getCurrentConditions() {
        WeatherConditions conditions = new WeatherConditions();
        conditions.setCurrentTemp(Float.toString(forecast.getCurrently().getTemperature()));
        conditions.setSummary(forecast.getCurrently().getSummary());
        Gson gson = new Gson();
        return gson.toJsonTree(conditions);
    }

    public JsonElement getHourlyConditions() {
        WeatherHourly hourly = new WeatherHourly();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("E ha");
        JsonArray hourlyArray = new JsonArray();
        Details details = forecast.getHourly();
        for(Data d : details.getData()) {
            JsonObject o = new JsonObject();
            Instant i = Instant.ofEpochSecond(d.getTime());
            LocalDateTime dt = LocalDateTime.ofInstant(i, ZoneId.systemDefault());
            o.add("time", new JsonPrimitive(df.format(dt) ));
            o.add("summary", new JsonPrimitive(d.getSummary()));
            o.add("temp", new JsonPrimitive(Math.round(d.getTemperature()*100.0)/100.0));
            o.add("feelsLike", new JsonPrimitive(Math.round(d.getApparentTemperature()*100.0)/100.0));
            hourlyArray.add(o);
        }

        JsonObject records = new JsonObject();
        records.add("hourly", hourlyArray);
        return records;
    }
}
