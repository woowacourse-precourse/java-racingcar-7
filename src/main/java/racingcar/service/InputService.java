package racingcar.service;

import java.util.LinkedHashMap;
import java.util.Map;

public class InputService {

    public InputService() {
    }

    public Map<String, Integer> splitAndSaveCarName(String carNames) {
        Map<String, Integer> racingCar = new LinkedHashMap<>();

        for (String carName : carNames.split(",")) {
            carName = carName.trim();
            racingCar.putIfAbsent(carName, 0);
        }

        return racingCar;
    }

}
