package racingcar.domain;

public class Car {
    private final String name;
    private int position;

    private Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    protected void move(int value) {
        if (value >= 4) {
            this.position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
