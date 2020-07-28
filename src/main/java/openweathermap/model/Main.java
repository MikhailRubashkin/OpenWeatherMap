package openweathermap.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main{
    private Long temp;
    private Long feels_like;
    private Long temp_main;
    private Long temp_max;
    private Long pressure;
    private Long humidity;

    public Long getTemp() {
        return temp;
    }

    public void setTemp(Long temp) {
        this.temp = temp;
    }

    public Long getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(Long feels_like) {
        this.feels_like = feels_like;
    }

    public Long getPressure() {
        return pressure;
    }

    public void setPressure(Long pressure) {
        this.pressure = pressure;
    }

    public Long getHumidity() {
        return humidity;
    }

    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    public Long getTemp_main() {
        return temp_main;
    }

    public void setTemp_main(Long temp_main) {
        this.temp_main = temp_main;
    }

    public Long getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(Long temp_max) {
        this.temp_max = temp_max;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Main main = (Main) o;
        return Objects.equals(temp, main.temp) &&
                Objects.equals(feels_like, main.feels_like) &&
                Objects.equals(temp_main, main.temp_main) &&
                Objects.equals(temp_max, main.temp_max) &&
                Objects.equals(pressure, main.pressure) &&
                Objects.equals(humidity, main.humidity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temp, feels_like, temp_main, temp_max, pressure, humidity);
    }

    @Override
    public String toString() {
        return "Main{" +
                "temp='" + temp + '\'' +
                ", feels_like='" + feels_like + '\'' +
                ", temp_main='" + temp_main + '\'' +
                ", temp_max='" + temp_max + '\'' +
                ", pressure='" + pressure + '\'' +
                ", humidity='" + humidity + '\'' +
                '}';
    }
}
