package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private int moveCount;
    public Car(String carName) {
        this.carName = carName;
    }

    public final String getCarName() {
        return carName;
    }

    public final int getMoveCount() {
        return moveCount;
    }

    public final void moveOrStay() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            ++moveCount;
        }
    }

public final void printMoveCount() {
        System.out.println(carName + " : " + getSlashesForMoveCount());
    }

    private String getSlashesForMoveCount() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < moveCount; ++i) {
            sb.append('-');
        }
        return sb.toString();
    }
}
