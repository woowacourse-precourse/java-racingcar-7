package racingcar.domain;

import java.util.List;
import racingcar.model.Car;
import racingcar.util.RandomNumberGenerator;

public class Race {
    private final RandomNumberGenerator randomNumberGenerator;

    public Race(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void race(List<Car> racingCars) {
        for (Car car : racingCars) {
            int randomValue = randomNumberGenerator.generateRandomNumber();
            car.move(randomValue);
        }
    }
}
