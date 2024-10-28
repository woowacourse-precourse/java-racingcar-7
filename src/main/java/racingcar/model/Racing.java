package racingcar.model;

import racingcar.model.car.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static racingcar.common.Error.NOT_DUPLICATED_NAME;
import static racingcar.common.Error.NOT_NEGATIVE;

public class Racing {
    private final List<Car> cars;
    private final int moveCount;

    private Racing(List<Car> cars, int moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

    public static Racing of(List<Car> cars, int moveCount) {
        validateDuplication(cars);
        validateMoveCount(moveCount);
        return new Racing(cars, moveCount);
    }

    public void start() {
        for (int index = 0; index < moveCount; index++) {
            for (Car car : cars) {
                car.move();
            }
        }
    }

    public List<Car> getWinners() {
        int winnerPosition = findWinnerPosition();
        return getCarsEqualToWinnerPosition(winnerPosition);
    }

    private static void validateDuplication(List<Car> cars) {
        boolean isDuplicated = (cars.size() != cars.stream().distinct().toList().size());

        if (isDuplicated) {
            throw new IllegalArgumentException(NOT_DUPLICATED_NAME.getMessage());
        }
    }

    private static void validateMoveCount(int moveCount) {
        if (moveCount <= 0) {
            throw new IllegalArgumentException(NOT_NEGATIVE.getMessage());
        }
    }

    private List<Car> getCarsEqualToWinnerPosition(int winnerPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == winnerPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int findWinnerPosition() {
        List<Car> sortedCars = cars.stream()
                .sorted(Comparator.comparingInt(Car::getPosition).reversed())
                .toList();
        return sortedCars.getFirst().getPosition();
    }
}
