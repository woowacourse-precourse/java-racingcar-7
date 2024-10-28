package racingcar.model;

public class Car {

    public static final int MOVE_THRESHOLD = 4;

    private final CarName name;
    private int position;

    public Car(CarName name) {
        this.name = name;
    }

    public void moveIfRandomExceedsThreshold(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
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