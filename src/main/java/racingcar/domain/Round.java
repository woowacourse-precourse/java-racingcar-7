package racingcar.domain;

import racingcar.domain.Car;
import racingcar.exception.CustomException;
import racingcar.exception.ExceptionCode;

import java.util.List;

public class Round {

    final List<Car> cars;

    public Round(final List<Car> cars) {
        this.cars = cars;
    }

    public void play(final List<Integer> randomNumbers) {
        if (cars.size() != randomNumbers.size()) {
            throw new CustomException(ExceptionCode.SIZE_NOT_MATCHED);
        }
        for (int round=0; round<randomNumbers.size(); round++) {
            Car car = cars.get(round);
            car.execute(randomNumbers.get(round));
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Car car: cars) {
            builder.append(car).append("\n");
        }
        builder.append("\n");
        return builder.toString();
    }
}
