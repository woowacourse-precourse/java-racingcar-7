package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.RandomValue;

public class RaceService {

    public Cars start(Cars cars) {
        for (Car car : cars.getCars()) {
            car.process(RandomValue.generate());
        }

        return cars;
    }
}
