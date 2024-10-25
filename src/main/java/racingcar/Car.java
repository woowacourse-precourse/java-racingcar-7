package racingcar;

public class Car {

    private final String name;
    private int position;

    public Car(final String name) {
        CarValidator.name(name);
        this.name = name;
        this.position = 0;
    }

    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
