package racingcar;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        String cars = InputView.readCars();
        int trials = Integer.parseInt(InputView.readTrials());
        Racing racing = new Racing();
        Arrays.stream(cars.split(","))
                .map(Car::new)
                .forEach(racing::addCar);
        System.out.println(racing.race(trials));
    }
}
