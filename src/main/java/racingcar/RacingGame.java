package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int MIN_CAR_COUNT = 1;
    private static final int MAX_TOTAL_MOVES = 100;
    private static final int MIN_TOTAL_MOVES = 1;
    private static final int RANDOM_START_INCLUSIVE = 0;
    private static final int RANDOM_END_INCLUSIVE = 9;
    private static final int MOVE_THRESHOLD = 4;
    private Set<Car> cars = new HashSet<>();

    public List<Car> run(final List<String> carNames, final int totalMoves) {
        validateCarCount(carNames.size());
        registerCars(carNames);
        validateTotalMovesRange(totalMoves);

        for (int i = 0; i < totalMoves; i++) {
            moveCars();
            printCarStatus();
        }

        return getWinners();
    }

    private void validateCarCount(int count) {
        if (count < MIN_CAR_COUNT) {
            throw new IllegalArgumentException("자동차는 최소 1대 이상이어야 합니다");
        }
    }

    private void registerCars(final List<String> carNames) {
        carNames.stream()
                .map(Car::new)
                .forEach(this::registerCar);
    }

    private void validateTotalMovesRange(final int totalMoves) {
        if (totalMoves > MAX_TOTAL_MOVES || totalMoves < MIN_TOTAL_MOVES) {
            throw new IllegalArgumentException("이동 횟수는 최소 1회, 최대 100회여야합니다.");
        }
    }

    private void registerCar(final Car car) {
        boolean isAdded = cars.add(car);
        validateNameDuplicated(isAdded);
    }

    private void validateNameDuplicated(final boolean isAdded) {
        if (!isAdded) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다");
        }
    }

    private void moveCars() {
        cars.forEach(this::moveCarRandomly);
    }

    private void moveCarRandomly(final Car car) {
        if (Randoms.pickNumberInRange(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE) >= MOVE_THRESHOLD) {
            car.moveForward();
        }
    }

    private void printCarStatus() {
        cars.forEach(System.out::println);
        System.out.println();
    }

    private List<Car> getWinners() {
        return cars.stream()
                .filter(car -> car.getDistanceMovedForward() == getWinningDistance())
                .collect(Collectors.toList());
    }

    private int getWinningDistance() {
        return cars.stream()
                .mapToInt(Car::getDistanceMovedForward)
                .max()
                .getAsInt();
    }
}
