package openweathermap.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import openweathermap.model.WeatherPojo;
import openweathermap.repository.WeatherPojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;

@Service
public class WeatherS {

    @Autowired
    private WeatherPojoRepository weatherPojoRepository;

    public static final String WEATHER_URL =
            "http://api.openweathermap.org/data/2.5/weather?q=London,uk" +
                    "&units=metric&appid=241de9349721df959d8800c12ca4f1f3";

    public static final String WEATHER_URL2 =
            "http://api.openweathermap.org/data/2.5/weather?" +
                    "q=Oslo,&units=metric&appid=77d7bf10384d0beb90e02f4533c37535";


    public void jsonTo() throws JsonProcessingException {
        URL url = JsonUtils.createUrl(WEATHER_URL);
        String resultJson = JsonUtils.parseUrl(url);
        resultJson = resultJson.replaceAll("\\[", "").replaceAll("\\]", "");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        WeatherPojo weatherPojo = mapper.readValue(resultJson, WeatherPojo.class);
        weatherPojoRepository.save(weatherPojo);
    }

    public String getTemp() throws JsonProcessingException {
        ArrayList<String> list = new ArrayList<>();
        URL url = JsonUtils.createUrl(WEATHER_URL2);
        String resultJson = JsonUtils.parseUrl(url);
        JsonNode jsonNode = new ObjectMapper().readTree(resultJson);
        Integer temp = jsonNode.findPath("temp").intValue();
        String name = jsonNode.findPath("name").textValue();
        Converter<Integer, String> converter = String::valueOf;
        String converted = converter.convert(temp);

        list.add(name);
        list.add(" ");
        list.add(converted);
        list.add("°C");
        String a = list.toString();
        a = a.replaceAll("\\,", "").replaceAll("\\]", "").replaceAll("\\[", "");
        return a;
    }


    public String getIcon() throws JsonProcessingException {
        URL url = JsonUtils.createUrl(WEATHER_URL);
        String resultJson = JsonUtils.parseUrl(url);
        JsonNode jsonNode = new ObjectMapper().readTree(resultJson);
        String icon = jsonNode.findPath("icon").textValue();

        if ("01d".equals(icon)) {
            return "http://openweathermap.org/img/wn/01d@2x.png";
        } else if ("02d".equals(icon)) {
            return "http://openweathermap.org/img/wn/02d@2x.png";
        } else if ("03d".equals(icon)) {
            return "http://openweathermap.org/img/wn/03d@2x.png";
        } else if ("04d".equals(icon)) {
            return "http://openweathermap.org/img/wn/04d@2x.png";
        } else if ("09d".equals(icon)) {
            return "http://openweathermap.org/img/wn/09d@2x.png";
        } else if ("10d".equals(icon)) {
            return "http://openweathermap.org/img/wn/10d@2x.png";
        } else if ("11d".equals(icon)) {
            return "http://openweathermap.org/img/wn/11d@2x.png";
        } else if ("13d".equals(icon)) {
            return "http://openweathermap.org/img/wn/13d@2x.png";
        } else if ("50d".equals(icon)) {
            return "http://openweathermap.org/img/wn/50d@2x.png";
        } else if ("01n".equals(icon)) {
            return "http://openweathermap.org/img/wn/01n@2x.png";
        } else if ("02n".equals(icon)) {
            return "http://openweathermap.org/img/wn/02n@2x.png";
        } else if ("03n".equals(icon)) {
            return "http://openweathermap.org/img/wn/03d@2x.png";
        } else if ("04n".equals(icon)) {
            return "http://openweathermap.org/img/wn/04d@2x.png";
        } else if ("09n".equals(icon)) {
            return "http://openweathermap.org/img/wn/09d@2x.png";
        } else if ("10n".equals(icon)) {
            return "http://openweathermap.org/img/wn/10n@2x.png";
        } else if ("11n".equals(icon)) {
            return "http://openweathermap.org/img/wn/11d@2x.png";
        } else if ("13n".equals(icon)) {
            return "http://openweathermap.org/img/wn/13d@2x.png";
        } else if ("50n".equals(icon)) {
            return "http://openweathermap.org/img/wn/50d@2x.png";
        } else {
            return "Not found";
        }
    }
}
