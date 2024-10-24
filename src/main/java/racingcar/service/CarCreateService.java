package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarCreateService {
    public Cars fromString(String carNames) {
        List<String> carNameList = Arrays.asList(carNames.split(","));
        return fromList(carNameList);
    }

    private Cars fromList(List<String> carNameList) {
        List<Car> carList = carNameList.stream()
            .map(Car::new)
            .collect(Collectors.toList());
        return new Cars(carList);
    }
}
