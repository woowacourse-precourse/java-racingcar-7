package racingcar;

import static racingcar.ViewConstants.CAR_STATUS_FORMAT;
import static racingcar.ViewConstants.POSITION_MARK;
import static racingcar.ViewConstants.RACING_RESULT;

import java.util.List;

public class OutputView {
    public void printResult() {
        System.out.println(System.lineSeparator() + RACING_RESULT);
    }

    public void printCarStatus(List<CurrentCar> currentCars) {
        for (CurrentCar currentCar : currentCars) {
            System.out.printf(CAR_STATUS_FORMAT, currentCar.carName());
            System.out.println(POSITION_MARK.repeat(currentCar.position()));
        }
        System.out.println();
    }
}
