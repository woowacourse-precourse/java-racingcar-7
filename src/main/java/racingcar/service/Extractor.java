package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class Extractor {

    public Cars extractCars(List<String> carNames) {
        Cars cars = Cars.newCars();
        for (String s : carNames) {
            cars.addCar(Car.newCar(s));
        }
        return cars;
    }

    public List<String> getCarNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::strip).toList();
    }
}
