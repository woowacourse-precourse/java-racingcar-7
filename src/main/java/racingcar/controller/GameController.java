package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.util.InputValidator;
import racingcar.view.UserInputView;
import racingcar.view.UserOutputView;

public class GameController {

    public void run() {
        String carNames = UserInputView.inputCarNames();
        String moves = UserInputView.inputMoves();

        InputValidator.validate(carNames, moves);

        RacingGame racingGame = new RacingGame(carNames);

        UserOutputView.outputStartMessage();
        for (int round = 0; round < Integer.parseInt(moves); round++) {
            racingGame.moveCars();

            for (Car car : racingGame.getCars()) {
                UserOutputView.outputResult(car.getName(), car.getPosition());
            }
            System.out.println();
        }

        UserOutputView.outputWinners(racingGame.getWinners());
    }
}
