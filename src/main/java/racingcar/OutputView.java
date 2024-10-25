package racingcar;

import static racingcar.ViewConstants.CAR_STATUS_FORMAT;
import static racingcar.ViewConstants.POSITION_MARK;

public class OutputView {
    public void printCarStatus(CurrentCar currentCar) {
        System.out.printf(CAR_STATUS_FORMAT, currentCar.carName());
        System.out.println(POSITION_MARK.repeat(currentCar.position()));
    }
}
