package racingcar.io.output;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarCollection;

public interface Output {
    void printStartMessage();

    void printRoundResult(CarCollection cars);

    void printWinners(List<Car> winners);

    void printErrorMessage(String message);
}
