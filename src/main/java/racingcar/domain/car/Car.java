package racingcar.domain.car;

public class Car {
    private final CarName name;
    private int distance;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = 0;
    }

    public void moveForward() {
        this.distance++;
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance;
    }
}
