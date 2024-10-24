package racingcar.service;

import java.util.List;
import racingcar.domain.Car;

public interface RacingCarService {
    public List<Car> splitAndInitializeRacingCars(String carNames);

    public void startRacingCarGame(List<Car> racingCars);
}
