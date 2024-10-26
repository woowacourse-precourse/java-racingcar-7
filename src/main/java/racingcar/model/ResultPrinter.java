package racingcar.model;

import racingcar.domain.Car;
import racingcar.view.OutputView;
import java.util.List;

public class ResultPrinter {

    public void printResults(List<Car> cars, List<Car> winners) {
        OutputView.printExecutionResultMessage();
        OutputView.printRoundResult(cars);
        OutputView.printWinners(winners);
    }
}
