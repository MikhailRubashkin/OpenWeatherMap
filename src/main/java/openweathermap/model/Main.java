package openweathermap.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Main{
    private String temp;
    private String feels_like;
    private String temp_main;
    private String temp_max;
    private String pressure;
    private String humidity;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(String feels_like) {
        this.feels_like = feels_like;
    }

    public String getTemp_main() {
        return temp_main;
    }

    public void setTemp_main(String temp_main) {
        this.temp_main = temp_main;
    }

    public String getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(String temp_max) {
        this.temp_max = temp_max;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
