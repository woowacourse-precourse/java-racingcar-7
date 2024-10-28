package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Utils.ApplicationConstants;

public class Car {
    private final String carName;
    private final int currentPosition;

    public Car(String carName) {
        validateCarName(carName);
        this.carName = carName;
        this.currentPosition = 0;
    }

    private Car(String carName, int currentPosition) {
        this.carName = carName;
        this.currentPosition = currentPosition;
    }

    public Car move() {
        int newPosition = currentPosition + (Randoms.pickNumberInRange(0, 9) >= ApplicationConstants.MOVE_THRESHOLD ? 1 : 0);
        return new Car(carName, newPosition);
    }

    public String displayPosition() {
        return carName + " : " + "-".repeat(currentPosition);
    }

    public String getCarName() {
        return carName;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    private void validateCarName(String carName) {
        if (carName == null || carName.isEmpty() || carName.length() > ApplicationConstants.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ApplicationConstants.CAR_NAME_VALIDATION_MESSAGE);
        }
    }
}