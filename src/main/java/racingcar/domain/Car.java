package racingcar.domain;

public class Car {
    public final String name;
    public int moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int value) {
        if (value >= 4) {
            moveCount++;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(moveCount);
    }
}
