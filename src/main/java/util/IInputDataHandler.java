package util;

import com.google.gson.JsonObject;

public interface IInputDataHandler {
    public JsonObject getJsonFrom(String src);
    public Object getObjectFrom(String url, Object obj);
}
