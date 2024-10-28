package racingcar;

import manager.InputManager;
import manager.ResultManager;
import race.RacingProgress;
import validation.InputValidator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputManager inputManager = new InputManager(new InputValidator());
        RacingProgress racing = new RacingProgress(inputManager.inputCars(), inputManager.inputMoveCount());

        racing.raceStart();

        ResultManager resultManager = new ResultManager(racing.getWinnerCarList());
        System.out.println(resultManager.getWinners());
    }
}
