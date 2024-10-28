package racingcar.domain.race;

import java.util.List;
import racingcar.domain.car.Car;

public class Race {

    private final List<Car> cars;
    private final int raceCount;

    public Race(List<Car> cars, int raceCount) {
        this.cars = cars;
        this.raceCount = raceCount;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}