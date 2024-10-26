package racingcar;

public class Car {
    private String name;
    private long moveCount;

    public Car() {
        moveCount = 0;
    }

    public long getMoveCount() {
        return moveCount;
    }

    public void move() {
        moveCount++;
    }
}
