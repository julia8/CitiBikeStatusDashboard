package servlet;

import com.google.gson.JsonElement;
import org.junit.BeforeClass;
import org.junit.Test;
import util.DataFileHandler;
import util.IInputDataHandler;

import static org.junit.Assert.*;

public class CitiServletTest {
    @BeforeClass
    public static void setup() {
        System.setProperty("config.resource","/application_test.conf");
    }

    @Test
    public void testGetStatusByName() throws Exception {
        CitiServlet s = new CitiServlet() {
            @Override
            protected IInputDataHandler getHandler() {
                return new DataFileHandler();
            }
        };
        JsonElement elem = s.getStatus(null);
        assertNotNull(elem);
    }

    @Test
    public void testGetDefaultStatus() throws Exception {
        CitiServlet s = new CitiServlet() {
            @Override
            protected IInputDataHandler getHandler() {
                return new DataFileHandler();
            }
        };

        assertNotNull(s.getStatus("penn"));
    }
}