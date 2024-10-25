package racingcar;

import racingcar.io.InputHandler;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        CarFactory carFactory = new CarFactory();
        RaceController raceController = new RaceController(inputHandler, carFactory);
        raceController.runRace();
    }
}
