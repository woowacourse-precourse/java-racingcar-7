package service;

import domain.Car;
import java.util.ArrayList;
import java.util.List;

public class RacingService {
    public List<Car> getCarsList(String input) {
        String[] names = input.split(",");

        List<Car> carsList = new ArrayList<>();
        for (String name : names) {
            carsList.add(new Car(name));
        }

        return carsList;
    }
}
