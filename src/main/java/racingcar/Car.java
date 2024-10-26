package racingcar;

public class Car {
    private static final int POWER_THRESHOLD = 4;
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move(int power) {
        if (power >= POWER_THRESHOLD) {
            this.distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
