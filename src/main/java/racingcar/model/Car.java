package racingcar.model;

public class Car {
    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public String getName() {
        return this.name.toString();
    }

    public int getPosition() {
        return this.position.toInteger();
    }
}
