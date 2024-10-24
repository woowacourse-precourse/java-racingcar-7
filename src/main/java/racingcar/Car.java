package racingcar;

public class Car {

    private static final int MOVE_POLICY = 4;

    private final String name;
    private int moveCount;


    public Car(final String name) {
        this.name = name;
    }

    public boolean move(final int value) {
        if (value >= MOVE_POLICY) {
            moveCount++;
            return true;
        }

        return false;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

}
