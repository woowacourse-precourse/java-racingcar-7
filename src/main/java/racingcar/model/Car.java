package racingcar.model;

public class Car {
    private final String name;
    private int position = 0;
    private static final int MOVE_CRITERIA_VALUE = 4;

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomValue) {
        if (randomValue >= MOVE_CRITERIA_VALUE) {
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
