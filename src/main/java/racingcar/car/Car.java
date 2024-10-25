package racingcar.car;

public class Car {

    private final String name;

    private final int moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public void addMoveCount() {
        throw new UnsupportedOperationException("");
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
