package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.model.RacingGameModel;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameModel racingGameModel;

    public RacingGameController(InputView inputView, OutputView outputView, RacingGameModel racingGameModel) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGameModel = racingGameModel;
    }

    public void run() {
        List<String> carNames = inputView.getCarNames();
        int gameAttemptCount = inputView.getAttemptCount();

        List<Car> cars = racingGameModel.generateCarsFromNames(carNames);

        outputView.printEmptyLine();
        outputView.printGameResult();

        for (int count = 0; count < gameAttemptCount; count++) {
            racingGameModel.attemptMove(cars);
            outputView.printCarStatus(cars);
            outputView.printEmptyLine();
        }

        List<String> winners = racingGameModel.getWinners(cars);
        outputView.printWinners(winners);
    }
}
