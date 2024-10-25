package racingcar.service;

import java.util.List;
import racingcar.domain.Car;

public interface RacingGameService {
    List<Car> splitAndInitializeRacingCars(String carNames);

    void startCarRaceGame(List<Car> racingCars);
}
