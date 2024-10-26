package racingcar.controller;

import java.util.List;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.GameStatus;
import racingcar.domain.Message;
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

        gameService.saveCarName(gameStatus, carNameArray);

        List<Map<String, String>> updatedCarsNameAndPosition = gameService.progressGame(gameStatus, tryCount);

        System.out.println(Message.resultMessage());
        for (Map<String, String> updatedPosition : updatedCarsNameAndPosition) {
            gameView.displayCarPosition(updatedPosition);
            System.out.println();
        }
    }
}

