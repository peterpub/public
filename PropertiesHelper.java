package lib.git;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class PropertiesHelper {
    private static String absolutePath = "/etc/app.json";
    private static JSONObject json;
    static {
        try {  json = new JSONObject(FileUtils.readFileToString(new File(absolutePath)));        } catch (IOException e) {            e.printStackTrace();        }
    }
    public static String getProperty(String key){
        return json.getString(key);
    }
}