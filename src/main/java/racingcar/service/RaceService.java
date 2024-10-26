package racingcar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.util.RandomNumber;
import racingcar.util.Validator;

public class RaceService {

    public String[] splitCarNames(String carNames) {
        String[] splitNames = carNames.split(",");
        return splitNames;
    }

    public List<Car> createCars(String[] carNames) {
        List<Car> Cars = new ArrayList<>();
        for (String name : carNames) {
            Cars.add(new Car(name));
        }
        return Cars;
    }
}
