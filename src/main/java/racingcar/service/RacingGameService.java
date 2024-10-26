package racingcar.service;

import racingcar.model.Car;

import java.util.List;

public interface RacingGameService {
    List<Car> parseNameList(List<String> nameList);
    void moveCarRandomly(List<Car> cars);
}
