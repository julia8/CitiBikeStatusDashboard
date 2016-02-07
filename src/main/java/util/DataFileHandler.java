package util;

import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Julia on 2/4/2016.
 */
public class DataFileHandler extends JsonHandler implements IInputDataHandler {
    public JsonObject getJsonFrom(String url) {
        InputStream fis = null;
        try {
            fis = ClassLoader.getSystemResourceAsStream(url);
            return getJsonObjectFromStream(new InputStreamReader(fis));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
