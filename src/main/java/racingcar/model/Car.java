package racingcar.model;

public class Car {

    private final String name;
    private int pos;

    private Car(final String name, int pos) {
        this.name = name;
        this.pos = pos;
    }

    public static Car of(final String name) {
        return new Car(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }

    public void go() {
        this.pos++;
    }
}
