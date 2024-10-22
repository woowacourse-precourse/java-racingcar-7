package racingcar;

public class Car {
    private final String name;
    private int currentMoveCount;

    public Car(String name, int currentMoveCount) {
        this.name = name;
        this.currentMoveCount = 0;
    }
}
