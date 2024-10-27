package racingcar.Output;

import java.util.List;
import racingcar.Car;

public interface OutputHandler {
    void printCarNameRequest();

    void printRoundRequest();

    void printCarProgress(String carName, int position);

    void printWinners(List<Car> winners);

    void printNewLine();
}