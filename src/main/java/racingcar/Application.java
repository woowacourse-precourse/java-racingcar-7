package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        String[] carNames = Input.inputCarNames();
        int tryCounts = Input.inputTryCounts();

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        Output.printResult(cars, tryCounts);
    }
}
