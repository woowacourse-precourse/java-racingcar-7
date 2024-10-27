package racingcar.service;

import racingcar.domain.Car;

import java.util.List;

public interface CarSetup {

    List<Car> parseCarNames(String input);

    int parseAttemptCount(String input);
}
