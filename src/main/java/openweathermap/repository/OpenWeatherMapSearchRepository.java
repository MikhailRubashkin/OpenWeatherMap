package openweathermap.repository;

import openweathermap.model.OpenWeatherMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class OpenWeatherMapSearchRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public Collection<OpenWeatherMap> searchOpenWeatherMap(String text) {
        return mongoTemplate.find(Query.query(new Criteria()
                .orOperator(Criteria.where("description").regex(text, "i"),
                        Criteria.where("day").regex(text, "i"),
                        Criteria.where("city").regex(text, "i"))
        ), OpenWeatherMap.class);
    }
}
