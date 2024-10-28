package racingcar.service;

import java.util.HashMap;
import racingcar.exception.InputExceptionHandler;

public class CarService {

    public HashMap<String, Integer> splitCarNames(String carNames) {
        HashMap<String, Integer> cars = new HashMap<>();

        String[] names = carNames.split(",");
        InputExceptionHandler.validateCarName(names);

        for (String name : names) {
            cars.put(name.trim(), 0);
        }

        return cars;
    }

    public void updateCarLocation(HashMap<String, Integer> cars, String carName, boolean isForward) {
        if (isForward) {
            cars.put(carName, cars.get(carName) + 1);
        }
    }
}
