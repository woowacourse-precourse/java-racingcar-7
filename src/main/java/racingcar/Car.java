package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;


public class Car {
    private String name;
    private List<CarMovementState> movementLog = new ArrayList<>();
    private int moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            movementLog.add(CarMovementState.MOVE);
            moveCount++;
        } else {
            movementLog.add(CarMovementState.STOP);
        }
    }

    public List<CarMovementState> getMovementLog(int attempt) {
        return movementLog.subList(0, attempt);
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
