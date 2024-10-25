package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.GameStatus;
import racingcar.service.Validator;
import racingcar.view.GameView;

public class GameController {

    GameView gameView = new GameView();
    GameStatus gameStatus = new GameStatus();

    public void gameStart() {
        String carNames = gameView.getInputCarNames();
        String[] carNameArray = carNames.split(",");

        Validator.isCarNameBlank(carNameArray);
        Validator.isCarNameValidLength(carNameArray);
        Validator.isCarNameFormatValid(carNameArray);
        Validator.isCarNameDuplicate(carNameArray);

        for (String carName : carNameArray) {
            Car car = new Car(carName.trim());
            System.out.println("car = " + car);
            gameStatus.addCar(car);
        }

        String tryCount = gameView.getInputTryCount();
        Validator.isTryCountBlank(tryCount);
        Validator.isTryCountPositive(tryCount);

    }


}
