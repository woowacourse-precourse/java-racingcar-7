package racingcar.model;

import java.util.List;

public class RacingGame {
    private List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
