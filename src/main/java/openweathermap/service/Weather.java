package openweathermap.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import openweathermap.model.WeatherPojo;
import openweathermap.repository.WeatherPojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class Weather {

    @Autowired
    private WeatherPojoRepository weatherPojoRepository;

    public static final String WEATHER_URL =
            "http://api.openweathermap.org/data/2.5/weather?q=London,uk" +
                    "&units=metric&appid=241de9349721df959d8800c12ca4f1f3";


    public void jsonTo() throws JsonProcessingException {

        URL url = JsonUtils.createUrl(WEATHER_URL);
        String resultJson = JsonUtils.parseUrl(url);
        resultJson = resultJson.replaceAll("\\[", "").replaceAll("\\]", "");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        WeatherPojo weatherPojo = mapper.readValue(resultJson, WeatherPojo.class);
        weatherPojoRepository.save(weatherPojo);
    }
}
