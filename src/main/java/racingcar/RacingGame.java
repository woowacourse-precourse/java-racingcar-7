package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final TryCount count;

    public RacingGame(Cars cars, TryCount count) {
        this.cars = cars;
        this.count = count;
    }

    public void play() {
        for (int i = 0; i < count.getCount(); i++) {
            round();
        }

        System.out.println(checkWinner());
    }

    public void round() {
        for (Car car : cars.getCars()) {
            int i = Randoms.pickNumberInRange(0, 9);
            if (i >= 4) {
                car.move();
            }
        }

        System.out.println(cars);
    }

    public List<Car> checkWinner() {
        return cars.getWinner();
    }
}
