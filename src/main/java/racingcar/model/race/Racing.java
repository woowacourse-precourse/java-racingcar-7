package racingcar.model.race;

import racingcar.model.car.Cars;
import racingcar.model.number.Number;
import racingcar.model.number.RandomNumberGenerator;

public class Racing {
    private final Cars cars;

    public Racing(Cars cars) {
        this.cars = cars;
    }

    public void startRacing() {
        cars.getCars().forEach(car -> {
            final Number number = getRandomNumber();
            car.goOrStop(number);
        });
    }

    private Number getRandomNumber() {
        return RandomNumberGenerator.generate();
    }
}
