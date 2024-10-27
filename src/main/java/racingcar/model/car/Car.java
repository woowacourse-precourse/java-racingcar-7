package racingcar.model.car;

public abstract class Car {
    protected String name;
    protected int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public abstract void drive();

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }
}
