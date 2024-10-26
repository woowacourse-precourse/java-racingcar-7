package racingcar.game.model;

import java.util.List;
import racingcar.game.util.RandomNumberGenerator;

public class RacingCars {
    private static final int MOVE_THRESHOLD = 4;
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        this.cars.forEach(car -> {
            int randomNumber = RandomNumberGenerator.generate();
            moveIfCan(car, randomNumber);
        });
    }

    public List<RaceSnapshot> getCurrentSnapshots() {
        return this.cars.stream()
                .map(RaceSnapshot::new)
                .toList();
    }

    public Winners retrieveWinners() {
        int maxMoveCount = findMaxMoveCount();
        List<Car> winners = cars.stream()
                .filter(car -> car.hasMoveCount(maxMoveCount))
                .toList();

        return new Winners(winners);
    }

    private int findMaxMoveCount() {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);
    }

    private void moveIfCan(Car car, int randomNumber) {
        if (randomNumber < MOVE_THRESHOLD) {
            return;
        }

        car.increaseMoveCount();
    }
}