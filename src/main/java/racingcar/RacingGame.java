package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class RacingGame {
    private Set<Car> cars = new HashSet<>();

    public void run(final String carNames, final int totalMoves) {
        validateTotalMovesRange(totalMoves);

        for (String name : carNames.split(",")) {
            registerCar(new Car(name));
        }

        for (int i = 0; i < totalMoves; i++) {
            moveCars();
            printCarStatus();
        }
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

    private void moveCars() {
        cars.forEach(this::moveCarRandomly);
    }

    private void printCarStatus() {
        cars.forEach(System.out::println);
        System.out.println();
    }

    private void validateNameDuplicated(final boolean isAdded) {
        if (!isAdded) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다");
        }
    }

    private void moveCarRandomly(final Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.moveForward();
        }
    }
}
