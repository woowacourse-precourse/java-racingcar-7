package racingcar.service;

import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.model.RacingGameMaxRound;

import java.util.List;

public class RacingGameSettingService {
    private final CarFactory carFactory = new CarFactory();

    public List<Car> createCars(String carNames) {
        return carFactory.createCars(carNames);
    }

    public RacingGameMaxRound createGameRound(String roundInput) {
        return new RacingGameMaxRound(roundInput);
    }
}
