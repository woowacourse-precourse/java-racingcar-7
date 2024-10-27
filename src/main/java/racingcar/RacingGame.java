package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingGame {
    private Set<Car> cars = new HashSet<>();

    public List<Car> run(final List<String> carNames, final int totalMoves) {
        registerCars(carNames);
        validateTotalMovesRange(totalMoves);

        for (int i = 0; i < totalMoves; i++) {
            moveCars();
            printCarStatus();
        }

        return getWinners();
    }

    private void registerCars(List<String> carNames) {
        carNames.stream()
                .map(Car::new)
                .forEach(this::registerCar);
    }

    private void validateTotalMovesRange(int totalMoves) {
        if (totalMoves > 100 || totalMoves < 1) {
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
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
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
                .mapToInt(car -> car.getDistanceMovedForward())
                .max()
                .getAsInt();
    }
}
