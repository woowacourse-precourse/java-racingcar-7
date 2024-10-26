package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.view.OutputView;

public class OutputController {
    private final OutputView outputView;

    public OutputController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void printRoundResult(final Race race) {
        outputView.printEndLine();
        outputView.printGameResultMessage();
        race.getCarList().forEach(outputView::printRoundResult);
        outputView.printEndLine();
    }

    public void printWinners(final List<Car> winnerList) {
        outputView.printWinners(winnerList);
    }
}
