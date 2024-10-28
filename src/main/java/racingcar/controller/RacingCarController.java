package racingcar.controller;

import racingcar.dto.CarNamesInputHandler;
import racingcar.dto.GameRoundInputHandler;
import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {
    public void run() {
        // Car Names
        List<String> carNames = InputView.getCarNames();
        CarNamesInputHandler.handle(carNames);

        // Game Round
        String gameRound = InputView.getGameRound();
        GameRoundInputHandler.handle(gameRound);
        int parsedGameRound = Integer.parseInt(gameRound);

        RacingCars racingCars = new RacingCars(carNames);

        OutputView.printExecutionMessage();
        for(int i = 0; i < parsedGameRound; i++) {
            racingCars.moveCars();
            OutputView.printRoundResult(racingCars);
        }
        OutputView.printWinners(racingCars);
    }
}
