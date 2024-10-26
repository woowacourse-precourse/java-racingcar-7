package racingcar.service;

import java.util.LinkedHashMap;
import java.util.Map;

public class InputService {

    public void splitAndSaveCarName() {
        Map<String, Integer> racingCar = new LinkedHashMap<>();

        for (String carName : carNames.split(",")) {
            racingCar.putIfAbsent(carName, 0);
        }
    }
}
