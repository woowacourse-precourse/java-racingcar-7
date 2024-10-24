package racingcar.io.output;

import racingcar.domain.CarCollection;

public interface Output {
    void printStartMessage();

    void printRoundResult(CarCollection cars);

    void printWinners(CarCollection cars);

    void close();
}
