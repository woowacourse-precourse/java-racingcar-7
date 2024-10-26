package racingcar.model;

public class Car {
    private String name;
    private int position;
    private static final int START_POSITION = 0;
    private static final int MOVE_THRESHOLD = 4;
    private static final int MOVE_STEP = 1;

    public Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public String getName() {
        return name;
    }

    public void updatePosition(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            position += MOVE_STEP;
        }
    }

    public int getPosition() {
        return position;
    }
}
