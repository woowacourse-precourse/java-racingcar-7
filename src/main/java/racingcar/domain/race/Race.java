package racingcar.domain.race;

import racingcar.domain.car.Cars;
import racingcar.domain.random.RandomNumberGenerator;

public class Race {

    private final static Integer MIN_VALUE = 1;
    private final static Integer MAX_VALUE = 9;

    private final RandomNumberGenerator randomNumberGenerator;

    public Race(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void racing(Cars cars) {
        cars.forEach(car -> {
            Integer randomNumber = randomNumberGenerator.getRandomNumber(MIN_VALUE, MAX_VALUE);
            car.move(randomNumber);
        });
    }
}
