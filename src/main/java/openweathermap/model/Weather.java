package openweathermap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable {

    private String id;
    private String icon;
    private String main;
    private String description;

    Weather(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Objects.equals(id, weather.id) &&
                Objects.equals(icon, weather.icon) &&
                Objects.equals(main, weather.main) &&
                Objects.equals(description, weather.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, icon, main, description);
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", icon='" + icon + '\'' +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
