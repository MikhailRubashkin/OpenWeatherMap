package openweathermap.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import openweathermap.model.WeatherPojo;
import openweathermap.repository.OpenWeatherMapMongoRepository;
import openweathermap.repository.OpenWeatherMapSearchRepository;
import openweathermap.repository.WeatherPojoRepository;
import openweathermap.service.JsonUtils;
import openweathermap.service.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import openweathermap.model.OpenWeatherMap;

import java.net.URL;

@Controller
public class OpenWeatherMapController {


    @Autowired
    private
    OpenWeatherMapMongoRepository openWeatherMapMongoRepository;

    @Autowired
    private WeatherPojoRepository weatherPojoRepository;

    @Autowired
    private
    OpenWeatherMapSearchRepository openWeatherMapSearchRepository;

    @RequestMapping("/home")
    public String home(Model model) throws JsonProcessingException {

        URL url = JsonUtils.createUrl(Weather.WEATHER_URL);
        String resultJson = JsonUtils.parseUrl(url);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        WeatherPojo person = mapper.readValue(resultJson, WeatherPojo.class);
        weatherPojoRepository.save(person);
        model.addAttribute("list", openWeatherMapMongoRepository.findAll());
        model.addAttribute("lists", weatherPojoRepository.findAll());
        return "home";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute OpenWeatherMap openWeatherMap) {
        openWeatherMapMongoRepository.save(openWeatherMap);
        return "redirect:home";
    }

    @RequestMapping(value = "/search")
    public String search(Model model, @RequestParam String search) {
        model.addAttribute("list", openWeatherMapSearchRepository.searchOpenWeatherMap(search));
        model.addAttribute("search", search);
        return "home";
    }
}
