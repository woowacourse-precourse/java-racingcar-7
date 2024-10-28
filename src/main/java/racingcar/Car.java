package racingcar;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveForward() {
        this.position++;
    }

    public boolean isPositionSameAs(int value) {
        return this.position == value;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
