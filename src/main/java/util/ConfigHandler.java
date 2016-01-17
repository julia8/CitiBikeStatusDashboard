package util;

import com.typesafe.config.ConfigFactory;

import java.util.Collections;
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
            return config.getString("citibike2.statusUrl");
        }
    }

    public static Set getFavoriteStations(String whichSet) {
        Set<String> faves = new HashSet<String>();
        List<String> list = Collections.emptyList();
        try {
            list = config.getStringList("citibike2.stations.favorites." + whichSet);
        } catch (Exception e) {
            list = config.getStringList("citibike2.stations.favorites.chelsea");
        }

        for(String s: list) {
            faves.add(s);
        }
        return faves;
    }

}
