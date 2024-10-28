package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.Model.CarFactory;
import racingcar.Service.InputHandler;
import racingcar.Service.RacingGame;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            runRacingGame();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void runRacingGame() {
        InputHandler inputHandler = new InputHandler();
        List<String> carNamesList = inputHandler.getCarNames();
        String[] carNamesArray = carNamesList.toArray(new String[0]);
        List<Car> raceCars = CarFactory.createCars(carNamesArray);
        int numberOfAttempts = inputHandler.getAttemptCount();

        RacingGame racingGame = new RacingGame(raceCars, numberOfAttempts);
        racingGame.startRace();
    }
}
