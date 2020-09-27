package openweathermap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherPojo implements Serializable {

    private String base;
    private String visibility;
    private String dt;
    private String timezone;
    private Long id;
    private String name;

    @JsonProperty("weather")
    private Map<String, String> weather;

    @JsonProperty("clouds")
    private Map<String, Integer> clouds;

    @JsonProperty("coord")
    private Map<String, Integer> coord;

    @JsonProperty("main")
    private Map<String, Integer> main;

    @JsonProperty("sys")
    private Map<String, String> sys;

    @JsonProperty("wind")
    private Map<String, Integer> wind;

    WeatherPojo(){}

    public Map<String, Integer> getClouds() {
        return clouds;
    }

    public void setClouds(Map<String, Integer> clouds) {
        this.clouds = clouds;
    }

    public Map<String, Integer> getMain() {
        return main;
    }

    public void setMain(Map<String, Integer> main) {
        this.main = main;
    }

    public Map<String, Integer> getCoord() {
        return coord;
    }

    public void setCoord(Map<String, Integer> coord) {
        this.coord = coord;
    }

    public Map<String, String> getSys() {
        return sys;
    }

    public void setSys(Map<String, String> sys) {
        this.sys = sys;
    }

    public Map<String, Integer> getWind() {
        return wind;
    }

    public void setWind(Map<String, Integer> wind) {
        this.wind = wind;
    }

    public Map<String, String> getWeather() {
        return weather;
    }

    public void setWeather(Map<String, String> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherPojo that = (WeatherPojo) o;
        return Objects.equals(base, that.base) &&
                Objects.equals(visibility, that.visibility) &&
                Objects.equals(dt, that.dt) &&
                Objects.equals(timezone, that.timezone) &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(weather, that.weather) &&
                Objects.equals(clouds, that.clouds) &&
                Objects.equals(coord, that.coord) &&
                Objects.equals(main, that.main) &&
                Objects.equals(sys, that.sys) &&
                Objects.equals(wind, that.wind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, visibility, dt, timezone, id, name, weather, clouds, coord, main, sys, wind);
    }

    @Override
    public String toString() {
        return "WeatherPojo{" +
                "base='" + base + '\'' +
                ", visibility='" + visibility + '\'' +
                ", dt='" + dt + '\'' +
                ", timezone='" + timezone + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", weather=" + weather +
                ", clouds=" + clouds +
                ", coord=" + coord +
                ", main=" + main +
                ", sys=" + sys +
                ", wind=" + wind +
                '}';
    }
}
