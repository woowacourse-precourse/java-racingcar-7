package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRecord {
    private String carName;
    private List<Integer> moveCount = new ArrayList<>();
    ;

    public CarRecord(String carName) {
        this.carName = carName;
        this.moveCount.add(0);
    }

    public String getCarName() {
        return carName;
    }

    public Integer getMoveCount(Integer progressCount) {
        return moveCount.get(progressCount);
    }

    public void addMoveCount(Integer progressCount) {
        moveCount.add(progressCount);
    }
}
