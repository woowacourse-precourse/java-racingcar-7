package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int position = 0;
    private final String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }
}
