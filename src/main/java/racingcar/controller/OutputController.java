package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.view.OutputView;

public class OutputController {
    private final OutputView outputView;

    public OutputController(final OutputView outputView) {
        this.outputView = outputView;
    }

    public void printEndLine() {
        outputView.printEndLine();
    }

    public void printGameResultMessage() {
        outputView.printGameResultMessage();
    }

    public void printRoundResult(final Race race) {
        race.getCarList().forEach(outputView::printRoundResult);
    }

    public void printWinners(final List<Car> winnerList) {
        outputView.printWinners(winnerList);
    }
}
