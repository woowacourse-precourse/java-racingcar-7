package racingcar.model.car;

import java.util.List;
import racingcar.common.ErrorMessage;
import racingcar.model.number.Number;
import racingcar.model.number.RandomNumberGenerator;
import racingcar.model.parser.CarsParser;

public class Cars {
    private final List<Car> cars;

    public Cars(final String carNames) {
        final List<Car> cars = CarsParser.parse(carNames);
        validateCars(cars);
        this.cars = cars;
    }

    public void startRacing() {
        cars.forEach(car -> {
            final Number number = getRandomNumber();
            car.goOrStop(number);
        });
    }

    private void validateCars(final List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_LIST.getMessage());
        }
    }

    private Number getRandomNumber() {
        return RandomNumberGenerator.generate();
    }

    public List<Car> getCars() {
        return cars;
    }
}
