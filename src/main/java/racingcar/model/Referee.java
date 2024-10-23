package racingcar.model;

import java.util.HashMap;
import java.util.Map;
import racingcar.model.Car.Cars;

public class Referee {
    private final Map<String, Integer> refereeList = new HashMap<>();

    public Referee(Cars cars, int maxCarListSize, int gameNumber) {
      convertToRefereeList(cars, maxCarListSize);
    }

    private void convertToRefereeList(Cars cars, int maxCarListSize) {
        for (int i = 0; i < maxCarListSize; i++) {
            refereeList.put(cars.getCarListValue(i), 0);
        }
    }
}