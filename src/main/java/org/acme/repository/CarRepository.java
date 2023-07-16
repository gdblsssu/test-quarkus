package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class CarRepository implements PanacheRepository<Car> {

    public String getCountColor(){
        Map<String, Integer> colorMap = new HashMap<>();
        List<Car> carList = findAll().list();
        for(Car car: carList){
            Integer count = colorMap.get(car.getColor());
            if(count == null){
                colorMap.put(car.getColor(), 1);
            } else {
                colorMap.put(car.getColor(), count + 1);
            }
        }
        return colorMap.toString();
    }
}
