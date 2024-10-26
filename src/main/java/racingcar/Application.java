package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = UserInput.inputCars();
        int number = UserInput.inputNumberOfExecutions();
    }
}