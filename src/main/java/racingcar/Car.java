package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private int moveCount;
    private final StringBuffer slashForMoveCount = new StringBuffer();
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
            slashForMoveCount.append("-");
        }
    }

    public final StringBuffer printMoveCount() {
        StringBuffer totalMove = new StringBuffer();

        totalMove.append(carName);
        totalMove.append(" : ");
        totalMove.append(slashForMoveCount);
        totalMove.append("\n"); //result sample: "Jay : ---"

        return totalMove;
    }
}
