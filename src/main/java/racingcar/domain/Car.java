package racingcar.domain;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private final CarName name;
    private int position;

    public Car(String name) {
        this.name = new CarName(name);
        position = INITIAL_POSITION;
    }

    public void move(boolean canMove) {
        if (canMove) {
            position++;
        }
    }

    public boolean isFartherThan(Car other) {
        return position > other.position;
    }

    public boolean hasSamePositionWith(Car other) {
        return position == other.position;
    }

    public String getName() {
        return this.name.getCarName();
    }

    public int getPosition() {
        return position;
    }
}
