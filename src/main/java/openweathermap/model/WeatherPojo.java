package openweathermap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherPojo implements Serializable {

    private String base;
    private String visibility;
    private String dt;
    private String timezone;
    private Long id;
    private String name;

    @JsonProperty("weather")
    private List<Weather> weathers = new ArrayList<Weather>();

    @JsonProperty("clouds")
    private List<Clouds> clouds = new ArrayList<Clouds>();

    @JsonProperty("coord")
    private List<Coord> coord = new ArrayList<Coord>();

    @JsonProperty("main")
    private List<Main> main = new ArrayList<Main>();

    @JsonProperty("sys")
    private List<Sys> sys = new ArrayList<Sys>();

    @JsonProperty("wind")
    private List<Wind> wind = new ArrayList<Wind>();

    public List<Clouds> getClouds() {
        return clouds;
    }

    public void setClouds(List<Clouds> clouds) {
        this.clouds = clouds;
    }



    public List<Main> getMain() {
        return main;
    }

    public void setMain(List<Main> main) {
        this.main = main;
    }

    public List<Coord> getCoord() {
        return coord;
    }

    public void setCoord(List<Coord> coord) {
        this.coord = coord;
    }

    public List<Sys> getSys() {
        return sys;
    }

    public void setSys(List<Sys> sys) {
        this.sys = sys;
    }

    public List<Wind> getWind() {
        return wind;
    }

    public void setWind(List<Wind> wind) {
        this.wind = wind;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
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
                Objects.equals(weathers, that.weathers) &&
                Objects.equals(clouds, that.clouds) &&
                Objects.equals(coord, that.coord) &&
                Objects.equals(main, that.main) &&
                Objects.equals(sys, that.sys) &&
                Objects.equals(wind, that.wind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, visibility, dt, timezone, id, name, weathers, clouds, coord, main, sys, wind);
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
                ", weathers=" + weathers +
                ", clouds=" + clouds +
                ", coord=" + coord +
                ", main=" + main +
                ", sys=" + sys +
                ", wind=" + wind +
                '}';
    }
}
