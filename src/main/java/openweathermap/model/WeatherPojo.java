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

    @JsonProperty("cloud")
    private List<Clouds> cloud = new ArrayList<Clouds>();

    @JsonProperty("coords")
    private List<Coord> coords = new ArrayList<Coord>();

    @JsonProperty("main")
    private List<Main> main = new ArrayList<Main>();

    @JsonProperty("syss")
    private List<Sys> syss = new ArrayList<Sys>();

    @JsonProperty("winds")
    private List<Wind> winds = new ArrayList<Wind>();

    public List<Clouds> getCloud() {
        return cloud;
    }

    public void setCloud(List<Clouds> cloud) {
        this.cloud = cloud;
    }

    public List<Coord> getCoords() {
        return coords;
    }

    public void setCoords(List<Coord> coords) {
        this.coords = coords;
    }

    public List<Main> getMain() {
        return main;
    }

    public void setMain(List<Main> main) {
        this.main = main;
    }

    public List<Sys> getSyss() {
        return syss;
    }

    public void setSyss(List<Sys> syss) {
        this.syss = syss;
    }

    public List<Wind> getWinds() {
        return winds;
    }

    public void setWinds(List<Wind> winds) {
        this.winds = winds;
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
                Objects.equals(cloud, that.cloud) &&
                Objects.equals(coords, that.coords) &&
                Objects.equals(main, that.main) &&
                Objects.equals(syss, that.syss) &&
                Objects.equals(winds, that.winds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, visibility, dt, timezone, id, name, weathers, cloud, coords, main, syss, winds);
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
                ", cloud=" + cloud +
                ", coords=" + coords +
                ", main=" + main +
                ", syss=" + syss +
                ", winds=" + winds +
                '}';
    }
}
