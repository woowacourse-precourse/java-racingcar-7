package racingcar;

public class Car {

    private final String name;

    private long position;

    public Car(final String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        position++;
    }
}
