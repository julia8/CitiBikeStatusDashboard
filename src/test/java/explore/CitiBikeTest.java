package explore;

import com.google.gson.JsonElement;
import org.junit.BeforeClass;
import util.DataFileHandler;

import static org.junit.Assert.*;

public class CitiBikeTest {
    @BeforeClass
    public static void setup() {
        System.setProperty("config.resource","/application_test.conf");
    }

    @org.junit.Test
    public void testGetStatusByGroupName() throws Exception {
        JsonElement status = (new CitiBike(new DataFileHandler())).getStatus("penn");
        assertNotNull(status);
    }
}