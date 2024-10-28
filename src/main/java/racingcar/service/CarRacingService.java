package racingcar.service;

import java.util.List;
import racingcar.domain.Car;

public interface CarRacingService {
    void runRound(List<Car> cars);

    boolean isMovable();

    List<Car> findWinners(List<Car> cars);
}
