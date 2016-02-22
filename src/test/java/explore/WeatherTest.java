package explore;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.typesafe.config.ConfigFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import util.DataFileHandler;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class WeatherTest {
    @BeforeClass
    public static void setup() {
        System.setProperty("config.resource","/application_test.conf");
    }

    @Test
    public void testGetConditions() throws Exception {
        Weather w = (new Weather(new DataFileHandler()));
        /* Current */
        JsonElement elem = w.getCurrentConditions();
        JsonObject obj = elem.getAsJsonObject();
        System.out.println("temp:"+ obj.toString());
        assertEquals("52.98", obj.get("currentTemp").getAsString());
        assertEquals("Mostly Cloudy", obj.get("summary").getAsString());

        /* Hourly*/
        elem = w.getHourlyConditions();

        JsonArray arr = elem.getAsJsonObject().get("hourly").getAsJsonArray();
        obj = arr.get(0).getAsJsonObject();
        assertEquals("Wed 11PM", obj.get("time").getAsString());
        assertEquals("Mostly Cloudy", obj.get("summary").getAsString());
        assertThat(52.79, equalTo(obj.get("temp").getAsDouble()));
        assertThat(52.79, equalTo(obj.get("feelsLike").getAsDouble()));
    }
}