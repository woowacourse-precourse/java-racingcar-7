package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String carName;
    private int forwardCount;

    public Car(String carName) {
        this.carName = carName;
        this.forwardCount = 0;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            forwardCount += 1;
        }
    }
}
