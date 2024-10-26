package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;


public class Car {
    private String name;
    private List<MoveStatus> moveLog = new ArrayList<>();
    private int moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            moveLog.add(MoveStatus.MOVE);
            moveCount++;
        } else {
            moveLog.add(MoveStatus.STOP);
        }
    }

    public List<MoveStatus> getMoveLog(int round) {
        return moveLog.subList(0, round);
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
