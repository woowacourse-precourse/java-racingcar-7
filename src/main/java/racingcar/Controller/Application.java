package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Model.Car;
import racingcar.Model.CarFactory;
import racingcar.Service.InputHandler;
import racingcar.Service.RacingGame;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            InputHandler inputHandler = new InputHandler();
            List<Car> raceCars = CarFactory.createCars(inputHandler.getCarNames());
            int numberOfAttempts = inputHandler.getAttemptCount();

            RacingGame racingGame = new RacingGame(raceCars, numberOfAttempts);
            racingGame.startRace();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
