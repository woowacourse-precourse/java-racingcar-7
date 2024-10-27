package racingcar.domain;

import java.util.List;
import racingcar.utils.RandomNoGenarator;

public class RacingGame {

    private Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void game() {

        List<Car> cars = this.cars.getCars();

        for (Car car : cars) {
            int randNo = RandomNoGenarator.getRandomNo();
            car.move(randNo);
        }

    }
}
