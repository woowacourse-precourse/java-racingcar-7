package racingcar;

import racingcar.car.CarFactory;
import racingcar.io.InputHandler;
import racingcar.race.RaceController;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        CarFactory carFactory = new CarFactory();
        RaceController raceController = new RaceController(inputHandler, carFactory);
        raceController.runRace();
        inputHandler.closeConsole(); // TODO
    }
}
