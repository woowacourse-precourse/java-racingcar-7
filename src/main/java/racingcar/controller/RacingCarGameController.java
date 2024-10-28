package racingcar.controller;

import static racingcar.view.Output.printRace;
import static racingcar.view.Output.printWinners;

import java.util.ArrayList;
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
        String[] carNames = input.getCarNames();
        List<Car> racingCars = convertToCars(carNames);
        int attemptCount = input.getAttemptCount();

        RacingCarGame racingCarGame = new RacingCarGame(racingCars, attemptCount);

        for (int i = 0; i < attemptCount; i++) {
            racingCarGame.raceEachCar();
            printRace(racingCarGame.getCars());
            System.out.println();
        }
        printWinners(racingCarGame.getWinnerList());

    }

    public List<Car> convertToCars(String[] carNames) {
        List<Car> racingCars = new ArrayList<>();
        for (String name : carNames) {
            Car car = new Car(name);
            car.validateNotExceedMaxLength();
            racingCars.add(new Car(name));
        }
        return racingCars;
    }
}
