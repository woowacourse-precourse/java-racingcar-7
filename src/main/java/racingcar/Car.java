package racingcar;

public class Car {
    private final String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void addMoveCount() {
        this.moveCount++;
    }
}
