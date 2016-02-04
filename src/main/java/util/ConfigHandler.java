package util;

import com.typesafe.config.ConfigFactory;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConfigHandler {
    private static com.typesafe.config.Config config = ConfigFactory.defaultApplication();

    public static String getURL(String type) {
        if("weather".equals(type)) {
            String urlSource = config.getString("darksky.forecastUrl");
            String apikey = config.getString("darksy.apikey");
            return urlSource.replace("{key}", apikey);
        } else {
            return config.getString("citibike2.statusUrl");
        }
    }

    public static Set getFavoriteStations(String whichSet) {
        Set<String> faves = new HashSet<String>();
        List<String> list;
        try {
            list = config.getStringList("citibike2.stations.favorites." + whichSet);
        } catch (Exception e) {
            list = config.getStringList("citibike2.stations.favorites.julia");
        }

        for(String s: list) {
            faves.add(s);
        }
        return faves;
    }

}
