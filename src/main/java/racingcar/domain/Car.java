package racingcar.domain;

public class Car {
    private String name;
    private int movedCnt;

    public Car(String name) {
        this.name = name;
        this.movedCnt = 0;
    }

    public void moveOrStop(boolean canMove) {
        if (canMove) {
            movedCnt++;
        }
    }

    public String getName() {
        return name;
    }

    public int getMovedCnt() {
        return movedCnt;
    }
}
