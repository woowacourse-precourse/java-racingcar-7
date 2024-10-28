package racingcar;

public class Car {
    private final String name;
    private int moveCount;

    // 생성자
    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move() {
        moveCount++;
    }
}
