package racingcar.output.result;

import racingcar.entity.Car;

import java.util.List;

public interface ResultOutputHandler {
    void printWinner(List<Car> history);
}
