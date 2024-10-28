package racingcar.service;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.validator.Validator;

public class InputService {
    private static InputService inputService;

    private InputService() {}

    public static InputService getInputServiceInstance() {
        if(inputService == null) {
            inputService = new InputService();
            return inputService;
        }
        return inputService;
    }

    public Map<String, Integer> splitAndSaveCarName(String carNames) {
        Map<String, Integer> racingCars = new LinkedHashMap<>();
        Validator validator = new Validator();

        for (String carName : carNames.split(",")) {
            carName = carName.trim();
            validator.isValidName(carName);
            racingCars.putIfAbsent(carName, 0);
        }

        return racingCars;
    }
}
