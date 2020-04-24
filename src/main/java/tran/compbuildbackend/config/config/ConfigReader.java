package tran.compbuildbackend.config.config;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import tran.compbuildbackend.exceptions.request.GenericRequestException;

import java.io.FileReader;

public class ConfigReader {
    // TODO: rename class with more descriptive name?

    public ConfigReader() { }

    public JSONObject getBackendConfigurationContent(String fileName) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            Object obj = parser.parse(new FileReader(fileName));
            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
            jsonObject = (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public String getContentFromKey(JSONObject jsonObject, String key) {
        String value = null;
        try {
            value = (String) jsonObject.get(key);
        } catch(Exception e) {
            e.printStackTrace();
            throw new GenericRequestException("there is currently an issue with the server.");
        }
        return value;
    }

}
