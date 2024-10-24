package racingcar.domain;

import java.util.List;
import racingcar.service.MoveRule;

public class Racing {
    private final List<Car> cars;

    private Racing(final List<Car> cars) {
        this.cars = cars;
    }

    public static Racing create(final List<Car> cars) {
        return new Racing(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void playRacingCar(MoveRule moveRule) {
        for (Car car : cars) {
            car.move(moveRule.tryMove());
        }
    }

}
