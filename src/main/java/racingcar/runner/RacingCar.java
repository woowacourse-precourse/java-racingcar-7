package racingcar.runner;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.runner.dto.CarDto;

public class RacingCar {

    private final String carString;
    private final String roundString;

    public RacingCar(String carString, String roundString) {
        this.carString = carString;
        this.roundString = roundString;
    }

    public String run() {
        return "";
    }

    private void updateMovementStatusByCar(CarDto car) {
        int movementStatus = car.getMovementStatus() + this.getMovingStatus();
        car.setMovementStatus(movementStatus);
    }

    private int getMovingStatus() {
        int minForMovingForward = 4;
        int random = Randoms.pickNumberInRange(0, 9);

        if (random < minForMovingForward) {
            return 0;
        }

        return 1;
    }
}
