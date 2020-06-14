package openweathermap.service;

import org.springframework.stereotype.Component;

@Component
public class Weather {

    public static final String WEATHER_URL =
            "http://api.openweathermap.org/data/2.5/weather?q=London,uk" +
                    "&units=metric&appid=241de9349721df959d8800c12ca4f1f3";

}
