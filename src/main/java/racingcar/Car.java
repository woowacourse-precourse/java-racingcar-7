package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private int distance;

    public Car(final String carName) {
        validateCarName(carName);

        this.carName = carName;
        this.distance = 0;
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
        }
    }

    public void foward() {
        if (canFoward()) {
            distance += 1;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    private boolean canFoward() {
        return Randoms.pickNumberInRange(0, 9) > 4;
    }
}
