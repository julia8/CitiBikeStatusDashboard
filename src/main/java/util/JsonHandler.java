package util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStreamReader;

public abstract class JsonHandler {

    protected static JsonObject getJsonObjectFromStream(InputStreamReader streamReader) throws IOException {
        Gson g = new Gson();
        return g.fromJson(streamReader, JsonObject.class);
    }

    protected static Object getObjectFromStream(InputStreamReader streamReader, Object obj) throws IOException {
        Gson g = new Gson();
        return g.fromJson(streamReader, obj.getClass());
    }
}
