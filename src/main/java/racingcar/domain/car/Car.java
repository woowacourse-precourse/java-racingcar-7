package racingcar.domain.car;

public class Car {
    private final CarName name;
    private final Distance distance;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = new Distance(0);
    }

    public void moveForward() {
        this.distance.moveForward();
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }
}
