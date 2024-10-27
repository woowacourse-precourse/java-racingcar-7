package racingcar;

import java.util.ArrayList;

public class Car {

    private String name;
    private int moveDistance=0;
    private ArrayList<Integer> moveLog=new ArrayList<>();

    public Car(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public ArrayList<Integer> getMoveLog() {
        return moveLog;
    }

    public void move() {
        this.moveDistance+=1;
    }

    public void updateMoveLog() {
        moveLog.add(moveDistance);
    }

}
