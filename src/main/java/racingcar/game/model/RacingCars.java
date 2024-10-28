package racingcar.game.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.game.error.ErrorMessage;
import racingcar.game.util.RandomNumberGenerator;

public class RacingCars {
    private static final int MOVE_THRESHOLD = 4;
    private final List<Car> cars = new ArrayList<>();

    public RacingCars(List<Car> cars) {
        cars.stream()
                .peek(this::checkAlreadyParticipant)
                .forEach(this::participate);
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

    private void checkAlreadyParticipant(Car car) {
        if (alreadyParticipate(car)) {
            throw new IllegalArgumentException(ErrorMessage.CANNOT_PARTICIPATE_DUPLICATE_CAR.getDescription());
        }
    }

    private boolean alreadyParticipate(Car car) {
        return this.cars.contains(car);
    }

    private void participate(Car car) {
        this.cars.add(car);
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