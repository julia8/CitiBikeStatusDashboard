package explore;

import com.google.transit.realtime.GtfsRealtime;
import util.ConfigHandler;

import java.io.*;
import java.net.URL;

/**
 * Quick & dirty dump to see what the data looks like.
 */
public class MtaSubwayTime {
    public static void main(String[] args) throws Exception {
        URL url = new URL(ConfigHandler.getURL("mta"));
        GtfsRealtime.FeedMessage feed = GtfsRealtime.FeedMessage.parseFrom(url.openStream());
        BufferedWriter out = new BufferedWriter(new FileWriter("mta_output.txt"));

        for (GtfsRealtime.FeedEntity entity : feed.getEntityList()) {
            /*(if (entity.hasTripUpdate()) {
                System.out.println(entity.getTripUpdate());
            }
            */

            out.write(entity.toString());
        }
    }
}
