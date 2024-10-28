package racingcar.model;

import java.util.List;
import racingcar.utils.RandomGenerator;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> playRound() {
        for (Car car : cars) {
            int randomValue = RandomGenerator.generateRandomNumber();
            car.move(randomValue);
        }
        return cars;
    }

}
