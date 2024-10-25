package racingcar.back.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String carName;
    private final List<Integer> movePhases;
    private Boolean isWinner;

    public Car(String carName) {
        this.carName = carName;
        this.movePhases = new ArrayList<>();
        this.isWinner = false;
    }

    public String getCarName() {
        return carName;
    }

    public List<Integer> getMovePhases() {
        return movePhases.stream().toList();
    }

    public Boolean getWinner() {
        return isWinner;
    }

    public Integer getMoveCount() {
        return movePhases.getLast();
    }

    public void setWinner() {
        isWinner = true;
    }

    public void moveIf(Boolean isMovable) {
        Integer movedValue = isMovable.compareTo(Boolean.FALSE);

        Integer lastElement = 0;
        if (movePhases.isEmpty() == false) {
            lastElement = movePhases.getLast();
        }
        movePhases.add(lastElement + movedValue);
    }

}
