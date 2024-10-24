package racingcar.domain;

public class Car {
    private final String name;
    private int location;

    public Car(final String name) {
        this.name = name;
        this.location = 0;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void plusLocation() {
        this.location += 1;
    }
}
