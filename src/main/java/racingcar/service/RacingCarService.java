package racingcar.service;

import java.util.HashMap;
import java.util.Map;

public class RacingCarService {
    public Map<String, String> validateCarNames(String carName) {
        Map<String, String> cars = new HashMap<>();

        String[] carNames = carName.split(",");

        for (String car : carNames) {
            if (car.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하로만 가능합니다.");

            cars.put(car, "");
        }
        return cars;
    }

}
