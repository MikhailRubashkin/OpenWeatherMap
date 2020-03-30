package openweathermap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class OpenWeatherMapApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenWeatherMapApplication.class, args);
    }

    public void run() {
    }
}
