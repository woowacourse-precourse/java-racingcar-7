package racingcar.game;

import racingcar.data.GameData;
import racingcar.dto.Car;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

import java.util.List;

public class RacingGame {
    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();
    private final GameData gameData = new GameData();
    private final WinnerDecider winnerDecider = new WinnerDecider();
    public void run() {
        outputHandler.printAskCarNames();
        String[] carNames = inputHandler.getCarNames();

        outputHandler.printAskTryNum();
        int tryNum = inputHandler.getTryNum();
        if (tryNum == 0) {
            return;
        }

        playGame(carNames, tryNum);

        List<Car> car = winnerDecider.decideWinner(gameData);

        outputHandler.printCarsRacingResult(gameData);
        outputHandler.printWinner(car);
    }

    private void playGame(String[] carNames, int tryNum) {
        RacingGameManager racingGameManager = new RacingGameManager();
        racingGameManager.prepareGameRounds(tryNum, carNames);
        racingGameManager.startGame(gameData);
    }
}
