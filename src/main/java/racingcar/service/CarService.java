package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;

public class CarService {

    public Cars createCars (String rawCarNames) {
        List<String> carNames = Arrays.asList(rawCarNames.split(","));

        return new Cars(carNames);
    }
}
