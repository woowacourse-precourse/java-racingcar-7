package racingcar.game;

import racingcar.dto.Car;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

import java.util.List;

public class RacingGame {
    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public void run() {
        outputHandler.printAskCarNames();
        String[] carNames = inputHandler.getCarNames();

        outputHandler.printAskTryNum();
        int tryNum = inputHandler.getTryNum();
        if (tryNum == 0) {
            return;
        }

        RacingGameManager racingGameManager = new RacingGameManager(tryNum, carNames);
        outputHandler.printResultMessage();
        List<Car> cars = racingGameManager.startGame();

        outputHandler.printWinner(cars);
    }
}
