package explore;

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
        (new Weather(new DataFileHandler())).getCurrentConditions();
    }
}