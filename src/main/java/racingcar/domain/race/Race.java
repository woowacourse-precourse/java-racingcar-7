package racingcar.domain.race;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.random.RandomNumberGenerator;

import java.util.List;

public class Race {

    private final static Integer MAX_VALUE = 9;
    private final static Integer MIN_VALUE = 1;

    private final RandomNumberGenerator defaultRandomNumberGenerator;

    public Race(RandomNumberGenerator defaultRandomNumberGenerator) {
        this.defaultRandomNumberGenerator = defaultRandomNumberGenerator;
    }

    public void racing(Cars cars) {

        List<Car> getCars = cars.getCars();

        getCars.forEach(car -> {
            Integer randomNumber = defaultRandomNumberGenerator.getRandomNumber(MIN_VALUE, MAX_VALUE);
            car.move(randomNumber);
        });
    }
}
