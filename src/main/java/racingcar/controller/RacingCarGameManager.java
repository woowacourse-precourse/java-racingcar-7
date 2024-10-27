package racingcar.controller;

import racingcar.service.GameLogicRunner;
import racingcar.validation.ValidateException;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarGameManager {
    private final Input input = new Input();
    private final Output output = new Output();
    private final ValidateException validateException = new ValidateException();

    public void runGame() {
        try {
            String carName = input.inputCarName();
            int tryCount = Integer.parseInt(validateException.isTryCountValid(input.inputTryCount()));
            GameLogicRunner gameLogicRunner = new GameLogicRunner(carName);

            for (int i = 0; i < tryCount; i++) {
                output.printRacingResullt(gameLogicRunner.getOneTryResult());
            }

            output.printFinalWinner(gameLogicRunner.getFinalWinner());
        } catch (IllegalArgumentException e) {
            output.printErrorMessage(e.getMessage());
            throw e;
        }
    }
}
