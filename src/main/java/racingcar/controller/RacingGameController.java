package racingcar.controller;

import static racingcar.utils.CarNameInputProcessor.splitCarNames;
import static racingcar.utils.TotalRoundsInputProcessor.parseTotalRounds;

import java.util.List;
import racingcar.domain.*;
import racingcar.view.*;

public class RacingGameController {
    public void run() {
        List<String> carNames = setCarNames();
        int moveCount = setTotalRounds();
        RacingGame racingGame = new RacingGame(carNames);
        startGame(racingGame, moveCount);
    }

    List<String> setCarNames() {
        String carNames = InputView.getCarNames();
        return splitCarNames(carNames);
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
