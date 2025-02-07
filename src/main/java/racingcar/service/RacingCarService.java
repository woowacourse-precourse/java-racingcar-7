package racingcar.service;

import racingcar.model.Car;

import java.util.List;

public interface RacingCarService {
    List<String> startRacing(int repeatNumber, List<Car> cars);
}
