package racingcar.service;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.validator.Validator;

public class InputService {

    public InputService() {
    }

    public Map<String, Integer> splitAndSaveCarName(String carNames) {
        Map<String, Integer> racingCar = new LinkedHashMap<>();
        Validator validator = new Validator();

        for (String carName : carNames.split(",")) {
            carName = carName.trim();
            validator.isValidName(carName);
            racingCar.putIfAbsent(carName, 0);
        }

        return racingCar;
    }
}
