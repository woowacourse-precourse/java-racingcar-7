package racingcar;

public class Car {

    private static final int MIN_MOVE_CONDITIONS = 4;
    private String name;
    private int distance;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MIN_MOVE_CONDITIONS) {
            this.distance++;
        }
    }
}
