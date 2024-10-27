package racingcar.service.collection;

import java.util.HashMap;
import java.util.Map;
import racingcar.Exception.ErrorMessage;

public class RacingCar {

    private final Map<String, Integer> racingCar = new HashMap<>();

    RacingCar(String CarNames) {
        String[] splitCarName = splitCarName(CarNames);

        for (String eachCarName : splitCarName) {
            racingCar.put(eachCarName, 0);
        }
    }

    public void moveForward(String carName) {
        racingCar.replace(carName, racingCar.get(carName) + 1);
    }

    private String[] splitCarName(String carName) {
        String[] splitCarName = carName.split(",");

        for (String eachCarName : splitCarName) {
            validateCarName(eachCarName);
        }
        return splitCarName;
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.LENGTH_OVER_FIVE.getMessage());
        }
    }
}
