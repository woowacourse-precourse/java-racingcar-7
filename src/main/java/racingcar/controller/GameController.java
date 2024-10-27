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
        startRace(racingGame, Integer.parseInt(moves));

        UserOutputView.outputWinners(racingGame.getWinners());
    }

    private void startRace(RacingGame racingGame, int moves) {
        for (int round = 0; round < moves; round++) {
            racingGame.moveCars();
            displayRoundResult(racingGame);
        }
    }

    private void displayRoundResult(RacingGame racingGame) {
        for (Car car : racingGame.getCars()) {
            UserOutputView.outputResult(car.getName(), car.getPosition());
        }
        System.out.println();
    }
}
