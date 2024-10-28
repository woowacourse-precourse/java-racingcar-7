package racingcar;

import java.util.List;
import java.util.ArrayList;

public class Racing {
    public static void startRace(String carNames, String tryCount) {
        List<Car> cars = nameCars(carNames);
        
    }

    private static List<Car> nameCars(final String carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames.split(",")) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }

            cars.add(new Car(carName));
        }

        return cars;
    }

   

}
