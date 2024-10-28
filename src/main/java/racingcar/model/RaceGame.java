package racingcar.model;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

public class RaceGame {
    private final Cars cars;
    private final int raceCount;
    private static final int MINIMUM_MOVE_THRESHOLD = 4;

    public RaceGame(Cars cars, int raceCount) {
        this.cars = cars;
        this.raceCount = raceCount;
    }
    public void moveCars() {
        for (Car car : cars.getCars()) {
            if (canMove()) cars.incrementCarPosition(car);
        }
        displayCurrentPositions();
    }

    private boolean canMove() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= MINIMUM_MOVE_THRESHOLD;
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }

    private void displayCurrentPositions() {
        for (Car car : cars.getCars()) {
            System.out.printf("%s : %s%n", car.getName(), "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void startRace(OutputView outputView) {
        for (int i = 0; i < raceCount; i++) {
            moveCars();
        }
        outputView.displayWinners(cars.getWinners());
    }
}
