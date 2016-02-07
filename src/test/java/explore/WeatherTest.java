package explore;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.typesafe.config.ConfigFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import util.DataFileHandler;

import java.io.File;

import static org.junit.Assert.*;

public class WeatherTest {
    @BeforeClass
    public static void setup() {
        System.setProperty("config.resource","/application_test.conf");
    }

    @Test
    public void testGetCurrentConditions() throws Exception {
        JsonElement elem = (new Weather(new DataFileHandler())).getCurrentConditions();
        JsonObject obj = elem.getAsJsonObject();
        System.out.println("temp:"+ obj.toString());
        assertEquals("52.98", obj.get("currentTemp").getAsString());
        assertEquals("Mostly Cloudy", obj.get("summary").getAsString());
    }
}