package racingcar;

import java.util.List;

public class Game {
    public static void run() {
        String userInput = InputManager.getInputData();
        ValidateCar.inputCar(userInput);
        String userInputCount = InputManager.getInputCountData();
        ValidateCount.inputCount(userInputCount);

        List<GameCar> doGame = GameCarParsingList.createGameCarList(userInput);
        int tryCount = ParsingCount.parseInputCountToInt(userInputCount);

        GameCarProcess gameCarProcess = new GameCarProcess(doGame, tryCount);
        gameCarProcess.gameProgress();

        List<String> findWinner = gameCarProcess.findWinner();
        OutputManager.printWinner(findWinner);
    }
}
