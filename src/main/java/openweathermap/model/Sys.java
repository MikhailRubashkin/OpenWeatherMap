package openweathermap.model;


import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Sys{
    private String type;
    private Long id;
    private String country;
    private String sunrise;
    private String sunset;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sys sys = (Sys) o;
        return Objects.equals(type, sys.type) &&
                Objects.equals(id, sys.id) &&
                Objects.equals(country, sys.country) &&
                Objects.equals(sunrise, sys.sunrise) &&
                Objects.equals(sunset, sys.sunset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, country, sunrise, sunset);
    }

    @Override
    public String toString() {
        return "Sys{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", country='" + country + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                '}';
    }
}
