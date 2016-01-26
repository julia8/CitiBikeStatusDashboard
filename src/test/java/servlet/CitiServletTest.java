package servlet;

import org.junit.Test;

import static org.junit.Assert.*;

public class CitiServletTest {
    @Test
    public void testGetStatusByName() throws Exception {
        CitiServlet s = new CitiServlet();
        assertNotNull(s.getStatus(null));
    }

    @Test
    public void testGetDefaultStatus() throws Exception {
        CitiServlet s = new CitiServlet();
        assertNotNull(s.getStatus("penn"));
    }
}