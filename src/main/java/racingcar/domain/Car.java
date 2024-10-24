package racingcar.domain;

public class Car {
    private final String name;
    private final Movement movement;

    public Car(String name) {
        this.name = name;
        this.movement = new Movement();
    }

    public void move(int number) {
        movement.advance(number);
    }

    public int getMovement(){
        return movement.getCount();
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, movement);
    }
}
