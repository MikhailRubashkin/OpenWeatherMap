package openweathermap.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Clouds {

    private String all;

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }
}
