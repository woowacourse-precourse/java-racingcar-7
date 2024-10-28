package racingcar.service;

import racingcar.error.ErrorStatus;

import java.util.HashMap;
import java.util.Map;

public class RacingCarService {
    public Map<String, String> validateCarNames(String carName) {
        Map<String, String> cars = new HashMap<>();

        String[] carNames = carName.split(",");

        for (String car : carNames) {
            if (car.length() > 5) throw new IllegalArgumentException(ErrorStatus.OVERSIZE_CAR_NAME);

            cars.put(car, "");
        }
        return cars;
    }

}
