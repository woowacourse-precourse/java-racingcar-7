package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class RaceService {

    public String[] splitCarNames(String carNames) {
        String[] splitNames = carNames.split(",");
        return splitNames;
    }

    public List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
