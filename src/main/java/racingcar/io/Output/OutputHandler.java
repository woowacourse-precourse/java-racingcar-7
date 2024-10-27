package racingcar.io.Output;

import java.util.List;
import racingcar.domain.Car.Car;

public interface OutputHandler {
    void printCarNameRequest();

    void printRoundRequest();

    void printCarProgress(String carName, int position);

    void printWinners(List<Car> winners);

    void printNewLine();
}