package racingcar.controller;

import static racingcar.utils.TotalRoundsInputProcessor.parseTotalRounds;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.utils.CarNameInputProcessor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    public void run() {
        List<String> carNames = setCarNames();
        int moveCount = setTotalRounds();
        RacingGame racingGame = new RacingGame(carNames);
        startGame(racingGame, moveCount);
    }

    List<String> setCarNames() {
        String carNames = InputView.getCarNames();
        CarNameInputProcessor carNameInputProcessor = new CarNameInputProcessor(carNames);
        return carNameInputProcessor.splitCarNames();
    }

    int setTotalRounds() {
        String totalRounds = InputView.getTotalRounds();
        return parseTotalRounds(totalRounds);
    }

    void startGame(RacingGame racingGame, int moveCount) {
        OutputView.printExecutionText();
        for (int i = 0; i < moveCount; i++) {
            List<Car> cars = racingGame.move();
            OutputView.printCarsMoveStatus(cars);
            System.out.println();
        }
        int maxMoveCount = racingGame.getMaxMoveCount();
        List<String> winners = racingGame.getWinners(maxMoveCount);
        OutputView.printFinalWinners(winners);
    }
}
