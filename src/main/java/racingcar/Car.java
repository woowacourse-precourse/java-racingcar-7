package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private int currentPosition;

    public Car(String carName) {
        this.carName = carName;
        currentPosition = 0;
    }

    public void move() {
        System.out.print(carName + " : ");
        for (int i = 0; i < currentPosition; i++) {
            System.out.print("-");
        }
        if (canMove()) {
            currentPosition++;
            System.out.print("-");
        }
        System.out.println();
    }

    public boolean canMove() { // 랜덤 정수 4 이상인 경우 자동차 이동 가능
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public String getCarName() {
        return carName;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
