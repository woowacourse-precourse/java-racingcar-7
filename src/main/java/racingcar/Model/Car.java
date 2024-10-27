package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int MAX_NAME_LENGTH = 5;
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
        int newPosition = currentPosition + (Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD ? 1 : 0);
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

    private static void validateCarName(String carName) {
        if (carName == null || carName.isEmpty() || carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열이거나 5자보다 길 수 없습니다.");
        }
    }
}