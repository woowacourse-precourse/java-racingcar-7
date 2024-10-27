package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private String moveNum;
    private int moveCount;

    public Car(String carName) {
        this.carName = carName;
        this.moveNum = "";
    }

    public void show() {
        System.out.println(carName + " : " + moveNum);
    }

    public void randomMove() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            moveNum += "-";
            moveCount++;
        }
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getCarName() {
        return carName;
    }
}
