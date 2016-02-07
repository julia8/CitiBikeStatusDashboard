package util;

import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DataFileHandler extends JsonHandler implements IInputDataHandler {
    public JsonObject getJsonFrom(String url) {
        return (JsonObject)getObjectFrom(url, new JsonObject());
    }

    public Object getObjectFrom(String url, Object obj) {
        InputStream fis = null;
        try {
            fis = ClassLoader.getSystemResourceAsStream(url);
            return getObjectFromStream(new InputStreamReader(fis), obj);
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
