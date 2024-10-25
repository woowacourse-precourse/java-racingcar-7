package racingcar.racing.model;

import java.util.List;

public interface RacingGameFactory {
    List<Car> createCars(List<String> carNameList, int totalCarNumber);
}
