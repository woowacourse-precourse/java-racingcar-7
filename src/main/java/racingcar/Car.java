package racingcar;

public class Car {
    private final String name;
    private int moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public void move() {
        this.moveCount++;
    }
}
