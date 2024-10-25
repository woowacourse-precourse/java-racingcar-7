package racingcar.model;

public class Car {
    private final String name;
    private int position;

    private static final int INIT_CAR_POSITION = 0;
    private static final int MOVE_THRESHOLD = 4;

    public Car(String name) {
        this.name = name;
        this.position = INIT_CAR_POSITION;
    }

    public void move(int value) {
        if (value >= MOVE_THRESHOLD) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}