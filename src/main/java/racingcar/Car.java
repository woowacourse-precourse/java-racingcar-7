package racingcar;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int location = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomValue) {
        if (randomValue >= MOVE_THRESHOLD) {
            location++;
        }
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
