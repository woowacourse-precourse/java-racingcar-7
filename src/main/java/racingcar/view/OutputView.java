package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public interface OutputView {
    void printCarNamesRequest();

    void printTryCountRequest();

    void printRoundResult(List<Car> cars);

    void printWinners(List<Car> winners);
}
