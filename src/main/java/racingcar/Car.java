package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Car {
    private String name;
    private List<CarMovementState> movementLog = new ArrayList<>();
    private int moveCount = 0;

    public Car(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다.");
        }
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
