package racingcar.service.collection;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.exception.ErrorMessage;

public class RacingCar {

    private final Map<String, Integer> racingCar = new LinkedHashMap<>();

    public RacingCar(String CarNames) {
        String[] splitCarName = splitCarName(CarNames);

        for (String eachCarName : splitCarName) {
            racingCar.put(eachCarName, 0);
        }
    }

    public List<String> getAllRacingCarName() {
        return racingCar.keySet().stream().toList();
    }

    public Integer getRacingCarPosition(String carNames) {
        return racingCar.get(carNames);
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
