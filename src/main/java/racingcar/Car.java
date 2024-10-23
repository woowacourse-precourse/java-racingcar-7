package racingcar;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void updateDistance() {
        this.distance += 1;
    }

    public int getDistance() {
        return distance;
    }
}
