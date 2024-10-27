package racingcar;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int step;

    public Car(String name) {
        this.name = name;
        this.step = 0;
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            this.step++;
        }
    }
}
