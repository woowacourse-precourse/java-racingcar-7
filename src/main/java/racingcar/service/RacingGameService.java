package racingcar.service;

import racingcar.domain.Cars;

public class RacingGameService {
    public Cars play(String carNames, int attempts) {
        Cars cars = Cars.from(carNames);

        for (int i = 0; i < attempts; i++) {
            cars.moveAll();
        }

        return cars;
    }
}
