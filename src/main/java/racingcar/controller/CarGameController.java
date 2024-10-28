package racingcar.controller;

import racingcar.domain.CarGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarGameController {
    public void start() {
        try {
            List<String> carNames = InputView.getCarNames();
            int attempts = InputView.getAttempts();

            CarGame game = new CarGame(carNames, attempts);
            game.playRounds();

            List<String> winners = game.getWinners();
            OutputView.printWinners(winners);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }
}
