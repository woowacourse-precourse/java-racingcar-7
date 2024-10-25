package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RacingGame {
    Set<Car> cars = new HashSet<>();

    public void run(final String carNames, final int totalMoves) {
        for (String name : carNames.split(",")) {
            registerCar(new Car(name));
        }

        for (int i = 0; i < totalMoves; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        Iterator<Car> iterator = cars.iterator();

        while(iterator.hasNext()) {
            Car car = iterator.next();
            moveCarRandomly(car);
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

    private void moveCarRandomly(final Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
    }
}
