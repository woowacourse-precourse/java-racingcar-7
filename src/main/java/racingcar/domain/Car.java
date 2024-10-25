package racingcar.domain;

public class Car {

    private final Name name;
    private final Position position;

    public Car(String carName) {
        name = new Name(carName);
        position = new Position();
    }

    public void moveForward() {
        position.move();
    }

    public String getName() {
        return name.toString();
    }

    @Override
    public String toString() {
        return String.format("%s : %s\n", name, position);
    }
}
