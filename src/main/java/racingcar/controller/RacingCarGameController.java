package racingcar.controller;

import static racingcar.view.Output.printRace;
import static racingcar.view.Output.printWinners;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingCarGame;
import racingcar.view.Input;

public class RacingCarGameController {
    private final Input input;

    public RacingCarGameController() {
        this.input = new Input();
    }

    public void run() {
        List<Car> carNames = input.getCars();
        int attemptCount = input.getAttemptCount();

        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.initialize(carNames);

        for (int i = 0; i < attemptCount; i++) {
            racingCarGame.raceEachCar();
            printRace(racingCarGame.getCars());
            System.out.println();
        }
        printWinners(racingCarGame.getWinnerList());

    }
}
