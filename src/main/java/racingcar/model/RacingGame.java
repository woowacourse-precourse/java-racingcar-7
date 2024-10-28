package racingcar.model;

import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int totalRounds;
    private final MovementStrategy movementStrategy;

    public RacingGame(List<Car> cars, int totalRounds, MovementStrategy movementStrategy) {
        validateRounds(totalRounds);
        this.cars = cars;
        this.totalRounds = totalRounds;
        this.movementStrategy = movementStrategy;
    }

    private void validateRounds(int rounds) {
        if (rounds < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public void executeRound() {
        cars.forEach(car -> car.advancePosition(movementStrategy.shouldMove()));
    }

    public int calculateMaxPosition() {
        return cars.stream().mapToInt(Car::getCurrentPosition).max().orElse(0);
    }

    public String determineWinners() {
        int maxPosition = calculateMaxPosition();
        return cars.stream()
                .filter(car -> car.getCurrentPosition() == maxPosition)
                .map(Car::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
    }
}
