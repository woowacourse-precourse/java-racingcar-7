package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int numberOfTrials;

    public RacingGame(int numberOfTrials, String... names) {
        this.numberOfTrials = numberOfTrials;
        this.cars = Arrays.stream(names)
                .map(Car::new)
                .toList();
    }

    public void trial() {
        cars.forEach(car -> {
            car.move(Randoms.pickNumberInRange(0, 9));
        });
    }
}
