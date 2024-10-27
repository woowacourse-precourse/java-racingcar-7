package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String userInput = InputData.getInputData();
        ValidateCar.validateInputCar(userInput);
        String userInputCount = InputCount.getInputCountData();
        ValidateCount.validateInputCount(userInputCount);

        List<GameCar> doGame = GameCarParsingList.createGameCarList(userInput);
        int tryCount = ParsingCount.parseInputCountToInt(userInputCount);

        GameCarProcess gameCarProcess = new GameCarProcess(doGame, tryCount);
        gameCarProcess.gameProgress();
    }
}
