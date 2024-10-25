package racingcar.car;

public class Car {

    private final String car;

    private final int moveCount;

    public Car(String car, int moveCount) {
        this.car = car;
        this.moveCount = 0;
    }

    public void addMoveCount() {
        throw new UnsupportedOperationException("");
    }

    public String getCar() {
        return car;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
