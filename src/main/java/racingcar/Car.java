package racingcar;

public class Car {

    private String name;
    private int distance;
    private static int MIN_MOVE_CONDITIONS = 4;

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
