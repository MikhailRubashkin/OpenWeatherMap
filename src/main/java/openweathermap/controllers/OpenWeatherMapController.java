package openweathermap.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import openweathermap.model.OpenWeatherMap;
import openweathermap.repository.OpenWeatherMapMongoRepository;
import openweathermap.repository.OpenWeatherMapSearchRepository;
import openweathermap.repository.WeatherPojoRepository;
import openweathermap.service.WeatherS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    private WeatherS weatherS;

    @RequestMapping("/home")
    public String home(Model model) throws JsonProcessingException {
            weatherS.jsonTo();
            model.addAttribute("list", openWeatherMapMongoRepository.findAll());
            model.addAttribute("lists", weatherPojoRepository.findAll());
            model.addAttribute("list3", weatherS.getIcon());
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
