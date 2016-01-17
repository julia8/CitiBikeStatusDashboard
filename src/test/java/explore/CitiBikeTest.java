package explore;

import com.google.gson.JsonElement;

import static org.junit.Assert.*;

/**
 * Created by Julia on 1/17/2016.
 */
public class CitiBikeTest {

    @org.junit.Test
    public void testGetStatusByGroupName() throws Exception {
        JsonElement status = CitiBike.getStatus("penn");
        assertNotNull(status);
    }
}