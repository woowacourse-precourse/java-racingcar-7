package racingcar.ViewInterface;

import java.util.List;
import racingcar.Domain.Car;

public interface OutputView {
    void printRaceResult();
    void printRoundResult(List<Car> cars);
    void printWinners(List<String> winners);
}
