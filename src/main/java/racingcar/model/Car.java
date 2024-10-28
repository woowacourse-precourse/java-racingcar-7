package racingcar.model;

public class Car {

    public static final int MOVING_FORWARD = 4;

    private final CarName name;
    private int position;

    public Car(CarName name) {
        this.name = name;
    }

    public void moveRandomly(int randomNumber) {
        if (randomNumber >= MOVING_FORWARD) {
            position++;
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}