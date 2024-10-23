package io.output;

import java.util.List;
import racingcar.Car;
import racingcar.Cars;

public interface Output {
    void printStartMessage();

    void printRoundResult(Cars cars);

    void printWinners(List<Car> winners);

    void printErrorMessage(String message);
}
