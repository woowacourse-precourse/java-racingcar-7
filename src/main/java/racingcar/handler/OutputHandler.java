package racingcar.handler;

import racingcar.domain.Car;

import java.util.List;

public interface OutputHandler {
    void printResults(List<Car> cars);
    void printWinners(List<Car> winners);
}
