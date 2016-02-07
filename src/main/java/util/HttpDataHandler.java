package util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStreamReader;

public class HttpDataHandler extends JsonHandler implements IInputDataHandler {
    private static HttpClient client = HttpClientBuilder.create().build();

    public JsonObject getJsonFrom(String url) {
        HttpGet getRequest = null;
        try {
            getRequest = new HttpGet(url);
            HttpResponse response = client.execute(getRequest);
            return getJsonObjectFromStream(new InputStreamReader(response.getEntity().getContent()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(getRequest != null) {
                getRequest.releaseConnection();
            }
        }
        return null;
    }

}
