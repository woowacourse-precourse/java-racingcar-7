package racingcar.domain;

public class Car {
    private final String name;
    private final Movement movement;

    public Car(String name, Movement movement) {
        this.name = name;
        this.movement = movement;
    }

    public void move(int number) {
        movement.advance(number);
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, movement);
    }
}
