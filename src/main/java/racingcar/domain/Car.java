package racingcar.domain;

public class Car {

    private final String name;
    private int moveCnt;

    public Car(String name) {
        this.name = name;
        moveCnt = 0;
    }

    public void moveForward() {
        this.moveCnt++;
    }

    public String getName() {
        return name;
    }

    public int getMoveCnt() {
        return moveCnt;
    }

}
