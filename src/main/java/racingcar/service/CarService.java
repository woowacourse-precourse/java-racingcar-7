package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public class CarService {
    private static final String COMMA = ",";

    public List<String> splitCarNames(final String carNames) {
        return new ArrayList<>(Arrays.stream(carNames.split(COMMA)).toList());
    }

    public List<Car> registerCar(final List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        carNames.forEach(carName -> carList.add(new Car(carName)));

        return carList;
    }
}
