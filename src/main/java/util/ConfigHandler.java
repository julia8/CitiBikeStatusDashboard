package util;

import com.typesafe.config.ConfigFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Julia on 1/15/2016.
 */
public class ConfigHandler {
    private static com.typesafe.config.Config config = ConfigFactory.defaultApplication();

    public static String getURL(String type) {
        if("mta".equals(type)) {
            String urlSource = config.getString("mta.url");
            String apikey = config.getString("mta.apikey");
            return urlSource.replace("{key}", apikey);
        } else {
            return config.getString("citibike.statusUrl");
        }
    }

    public static Set getFavoriteStations() {
        Set<String> faves = new HashSet<String>();
        List<String> list = config.getStringList("citibike.stations.favorites");
        for(String s: list) {
            faves.add(s);
        }
        return faves;
    }

}
