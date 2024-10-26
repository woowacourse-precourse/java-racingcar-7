package racingcar.domain;

public class Car {
    private final String name;
    public int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void go() {
        position++;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat((position));
    }
}
