package openweathermap.repository;

import openweathermap.model.WeatherPojo;
import org.springframework.data.repository.CrudRepository;

public interface WeatherPojoRepository extends CrudRepository<WeatherPojo, String> {
}
