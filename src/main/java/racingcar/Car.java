package racingcar;

public class Car {

    String name;
    long moveCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(long moveCount) {
        this.moveCount = moveCount;
    }

    public Car(String name, long moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    @Override
    public String toString() {
        return name + ", " + moveCount;
    }

}
