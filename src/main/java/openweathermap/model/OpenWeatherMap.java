package openweathermap.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OpenWeatherMap {

    private String id;

    private String day;

    private String city;

    private String description;

    private Integer year;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMake() {
        return day;
    }

    public void setMake(String make) {
        this.day = make;
    }

    public String getModel() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setModel(String model) {
        this.city = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
