package racingcar.model;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<String> carNames) {
        cars = carNames.stream()
                .map(Car::create)
                .toList();
    }

    public static Cars apply(List<String> carNames) {
        return new Cars(carNames);
    }

    public void playRound() {
        for (Car car : cars) {
            if (car.pickRandomNumber() >= 4) {
                car.moveForward();
            }
        }
    }
}
