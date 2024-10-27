package racingcar.model;

public class Car {
    private final Name name;

    public Car(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return this.name.toString();
    }
}
