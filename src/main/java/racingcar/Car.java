package racingcar;

public class Car {
    private String name;
    private long moveCount;

    Car() {
        moveCount = 0;
    }

    long getMoveCount() {
        return moveCount;
    }

    void move() {
        moveCount++;
    }
}
