package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;
import racingcar.input.InputManager;
import racingcar.output.OutputManager;

public class RacingController {

    private static final int MOVE_THRESHOLD = 4;
    private final InputManager inputManager;
    private final OutputManager outputManager;
    private List<Car> cars = new ArrayList<>();

    public RacingController(InputManager inputManager, OutputManager outputManager) {
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }

    public void setupGame() {
        cars = inputManager.getCars();
    }

    public void startRace() {
        long attemptCount = inputManager.getAttemptCount();
        for (long i = 0; i < attemptCount; i++) {
            proceedRace();
            outputManager.displayPosition(cars);
            System.out.println();
        }
    }

    public void displayWinners() {
        List<Car> winners = determineWinners();
        outputManager.displayWinners(winners);
    }

    private void proceedRace() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= MOVE_THRESHOLD) {
                car.move();
            }
        }
    }

    private List<Car> determineWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream().filter(car -> car.getPosition() == maxPosition).toList();
    }
}
