package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    final List<Car> racingCars;

    public Cars(String carNames) {
        racingCars = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            racingCars.add(new Car(carName));
        }
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }
}
