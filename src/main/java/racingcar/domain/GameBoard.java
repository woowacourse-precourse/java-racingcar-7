package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private final List<Car> cars = new ArrayList<>();

    public void setupCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
