package racingcar.racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private final String name;

    private final List<Integer> positionLog;

    private Boolean isWinner;


    public Car(String name) {
        this.name = name;
        this.positionLog = new ArrayList<>();
        this.isWinner = Boolean.FALSE;
    }


    public String getName() {
        return name;
    }

    public List<Integer> getPositionLog() {
        return positionLog;
    }

    public Integer getPosition() {
        if (positionLog.isEmpty()) {
            return 0;
        }
        return positionLog.getLast();
    }

    public void setWinner() {
        isWinner = Boolean.TRUE;
    }

    public Boolean getWinner() {
        return isWinner;
    }


    public void move(Integer move) {
        if (positionLog.isEmpty()) {
            positionLog.add(move);
        }
        else {
            positionLog.add(getPosition() + move);
        }
    }
}
