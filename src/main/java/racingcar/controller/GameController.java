package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.GameStatus;
import racingcar.service.GameService;
import racingcar.service.Validator;
import racingcar.view.GameView;

public class GameController {
    GameService gameService = new GameService();
    GameView gameView = new GameView();
    GameStatus gameStatus = new GameStatus();

    public void gameStart() {
        String carNames = gameView.getInputCarNames();
        String[] carNameArray = carNames.split(",");

        Validator.isCarNameBlank(carNameArray);
        Validator.isCarNameValidLength(carNameArray);
        Validator.isCarNameFormatValid(carNameArray);
        Validator.isCarNameDuplicate(carNameArray);

        String tryCountStr = gameView.getInputTryCount();
        int tryCount = Integer.parseInt(tryCountStr);
        Validator.isTryCountBlank(tryCountStr);
        Validator.isTryCountPositive(tryCount);

        for (String carName : carNameArray) {
            Car car = new Car(carName.trim(), 0);
            gameStatus.addCar(car);
        }

        gameService.progressGame(gameStatus, tryCount);

    }
}
