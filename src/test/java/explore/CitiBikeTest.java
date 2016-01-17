package explore;

import static org.junit.Assert.*;

/**
 * Created by Julia on 1/17/2016.
 */
public class CitiBikeTest {

    @org.junit.Test
    public void testGetStatus() throws Exception {
        // This test is not correct... how to assert when data may be different everytime?
        System.out.println(CitiBike.getStatus("default"));
        System.out.println(CitiBike.getStatus("set2"));
    }
}