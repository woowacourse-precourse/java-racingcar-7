package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.strategy.ModeType;

public class Racing {
    private final List<Car> racingCars;

    public Racing(List<Car> cars) {
        this.racingCars = cars;
    }

    public void tryMovingCars() {
        racingCars.forEach(Car::tryMoving);
    }

    public void setRacingCarMode(ModeType modeType) {
        racingCars.forEach(car -> car.setMode(ModeType.createCarMode(modeType)));
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }
}
