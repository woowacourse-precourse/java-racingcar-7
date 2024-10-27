package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingManager {
    private String winners = "";
    private final List<Car> cars;
    private final int tryCount;

    public RacingManager(List<Car> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void playRounds() {
        for (int i = 0; i < tryCount; i++) {
            moveCars();
            displayPositions();
            System.out.println();
        }
        identifyWinners();
    }

    public String getWinners() {
        return winners;
    }

    private void moveCars() {
        cars.forEach(Car::attemptMoveForward);
    }

    private void displayPositions() {
        cars.forEach(Car::displayPosition);
    }

    private void identifyWinners() {
        int maxPositionLength = findMaxPosition();
        List<String> winnerNames = findWinnerNames(maxPositionLength);
        winners = String.join(", ", winnerNames);
    }

    private int findMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }

    private List<String> findWinnerNames(int maxPositionLength) {
        return cars.stream()
            .filter(car -> car.getPosition() == maxPositionLength)
            .map(Car::getName)
            .toList();
    }
}
