package openweathermap.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Component;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class JsonUtils {

    public static String parseUrl(URL url) {
        if (url == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader
                (url.openStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static String parseCurrentWeatherJson(String resultJson) {
        try {
            JSONObject weatherJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
            weatherJsonObject.get("name");
            //weatherJsonObject.get("main");
            //weatherJsonObject.get("description");
            JSONArray weatherArray = (JSONArray) weatherJsonObject.get("weather");
            JSONObject weatherData = (JSONObject) weatherArray.get(0);
                    weatherData.get("description");
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return resultJson;
    }

    public static URL createUrl(String link) {
        try {
            return new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
