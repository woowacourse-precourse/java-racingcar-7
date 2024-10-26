package racingcar.domain.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingGame {

    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void round() {
        for (Car car : cars.getCars()) {
            int i = Randoms.pickNumberInRange(0, 9);
            if (i >= 4) {
                car.move();
            }
        }

    }

    public List<Car> checkWinner() {
        return cars.getWinner();
    }
}
