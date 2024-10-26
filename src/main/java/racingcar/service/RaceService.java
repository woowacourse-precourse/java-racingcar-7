package racingcar.service;

import java.util.List;
import racingcar.model.Car;

public interface RaceService {
    void makeCars(List<String> names);

    List<Car> startRace();

    List<Car> getWinner();
}
