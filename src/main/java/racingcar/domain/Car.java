package racingcar.domain;

public class Car {
    private final String name;
    private int position;

    private Car(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public static Car create(final String name) {
        return new Car(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(final int distance) {
        position += distance;
    }

}
