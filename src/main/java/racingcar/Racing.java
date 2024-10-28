package racingcar;

import java.util.List;
import java.util.ArrayList;

public class Racing {
    public static void startRace(String carNames, String tryCount) {
        List<String> cars = nameCars(carNames);
    }

    private static List<String> nameCars(final String carNames) {
        List<String> cars = new ArrayList<String>();

        for (String car : carNames.split(",")) {
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            }

            cars.add(car);
        }

        return cars;
    }

}
