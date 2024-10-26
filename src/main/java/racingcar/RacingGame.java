package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public void initializeCars(List<Car> cars, String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void run() {
        List<Car> cars = new ArrayList<>();
        initializeCars(cars, Input.inputCarNames());
        int tryCounts = Input.inputTryCounts();
        Output.printResult(cars, tryCounts);
    }
}
