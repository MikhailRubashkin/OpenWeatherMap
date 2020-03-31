package openweathermap.controllers;

import openweathermap.repository.OpenWeatherMapMongoRepository;
import openweathermap.repository.OpenWeatherMapSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import openweathermap.model.OpenWeatherMap;

@Controller
public class OpenWeatherMapController {

    @Autowired
    OpenWeatherMapMongoRepository openWeatherMapMongoRepository;

    @Autowired
    OpenWeatherMapSearchRepository openWeatherMapSearchRepository;

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("list", openWeatherMapMongoRepository.findAll());
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
