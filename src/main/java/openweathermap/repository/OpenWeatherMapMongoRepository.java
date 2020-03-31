package openweathermap.repository;

import openweathermap.model.OpenWeatherMap;
import org.springframework.data.repository.CrudRepository;

public interface OpenWeatherMapMongoRepository extends CrudRepository<OpenWeatherMap, String> {
}
