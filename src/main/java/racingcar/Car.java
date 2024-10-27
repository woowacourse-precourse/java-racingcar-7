package racingcar;

public class Car {
    private final String name;
    private int distance = 0;

    public Car(String carName) {
        this.name = carName;
    }

    public void move() {
        distance += 1;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
