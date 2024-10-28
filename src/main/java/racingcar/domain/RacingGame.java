package racingcar.domain;

import java.util.List;

public class RacingGame {

    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void game(GameRule gameRule) {

        List<Car> cars = this.cars.getCars();

        for (Car car : cars) {
            if (gameRule.isMovable()) {
                car.move();
            }
        }
    }
}
