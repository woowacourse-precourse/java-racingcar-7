package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;

public class CarMover {

    private static final int START_OF_RANGE = 0;
    private static final int END_OF_RANGE = 9;
    private static final int MOVE_STANDARD = 4;

    public void moveCars(List<Car> carList) {
        carList.forEach(this::tryMoveCar);
    }

    private void tryMoveCar(Car car) {
        if (canMove(Randoms.pickNumberInRange(START_OF_RANGE, END_OF_RANGE))) {
            car.move();
        }
    }

    private boolean canMove(int randomValue) {
        return randomValue >= MOVE_STANDARD;
    }
}
