package racingcar.services;

import java.util.Arrays;
import java.util.List;
import racingcar.models.Cars;

public class CarService {
    private Cars cars;

    public void createCarModel(String carNames) {
        List<String> carNameList = Arrays.asList(carNames.split(","));
        this.cars = new Cars(carNameList);
    }

    public void incrementCars() {
        cars.incrementDistance();
    }
}