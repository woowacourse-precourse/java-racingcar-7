package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;

public class CarMover {

    public void moveCars(List<Car> carList) {
        carList.forEach(this::tryMoveCar);
    }

    private void tryMoveCar(Car car) {
        if (canMove(Randoms.pickNumberInRange(0, 9))) {
            car.move();
        }
    }

    private boolean canMove(int randomValue) {
        return randomValue >= 4;
    }
}
