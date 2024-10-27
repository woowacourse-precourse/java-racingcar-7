package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String carName;
    private int moveCount;

    public Car(String carName) {
        this.carName = carName;
        moveCount = 0;
    }

    public void forwardCar(int randomNumber) {
        if (randomNumber >= 4) {
            moveCount += 1;
        }
    }

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
