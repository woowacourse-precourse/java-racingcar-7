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

    public String racing() {
        StringBuilder roundRecord = new StringBuilder();
        for (Car racingCar : racingCars) {
            roundRecord.append(racingCar.forwardProcess()).append("\n");
        }

        return roundRecord.toString();
    }
}
