package racingcar.Controller;

import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.InputView.inputTryCount;
import static racingcar.view.OutputView.printNewLine;
import static racingcar.view.OutputView.printWinners;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.OutputView;

public class GameController {

    public void run() {
        List<String> carNames = inputCarNames();
        int tryCount = inputTryCount();

        RacingGame racingGame = new RacingGame(carNames, tryCount);
        while (!racingGame.isFinished()) {
            racingGame.moveAll();
            racingGame.getCars().forEach(OutputView::printProgress);
            printNewLine();
        }

        List<Car> winners = racingGame.getWinners();
        printWinners(winners);
    }
}
