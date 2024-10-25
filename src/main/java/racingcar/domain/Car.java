package racingcar.domain;

public class Car {

    private final Name name;
    private final Position position;

    public Car(String carName) {
        name = new Name(carName);
        position = new Position();
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void moveForward(int randomNumber) {
        position.move(randomNumber);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.toString();
    }

    public Car copy() {
        return new Car(this.name, this.position);
    }

    @Override
    public String toString() {
        return String.format("%s : %s\n", name, position);
    }
}
