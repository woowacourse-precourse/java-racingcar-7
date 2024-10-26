package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class CarService {

    public List<Car> createCars(String carNames, int tryTimes) {
        List<Car> cars = new ArrayList<>();
        List<String> carNameList = extractNames(carNames);

        for (String carName : carNameList) {
            Car car = new Car(carName, tryTimes);
            cars.add(car);
        }
        return cars;
    }

    private List<String> extractNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }


}
