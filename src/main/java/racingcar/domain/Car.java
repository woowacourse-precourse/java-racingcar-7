package racingcar.domain;

public class Car {
    private final Name name;
    private final Position position;

    public Car(Name name) {
        this.name = name;
        this.position = new Position();
    }

    public void forward(int distance) {
        this.position.add(distance);
    }

    public String getName() {
        return this.name.toString();
    }

    @Override
    public String toString() {
        return this.name + " : " + this.position;
    }

    public boolean isMoreFar(Car car) {
        return this.position.isMoreFar(car.position);
    }

    public boolean isSamePosition(Car car) {
        return this.position.isSame(car.position);
    }
}
