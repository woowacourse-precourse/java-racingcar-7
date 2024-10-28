package racingcar.services;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

    public Map<String, Integer> getCarsInfo() {
        return cars.getInformation();
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }
}