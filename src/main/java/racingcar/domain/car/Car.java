package racingcar.domain.car;

public class Car implements Comparable<Car> {

    private final CarName name;
    private final MovementStrategy movementStrategy;
    private Position position;

    public Car(CarName name, MovementStrategy movementStrategy) {
        this(name, movementStrategy, Position.ZERO);
    }

    public Car(CarName name, MovementStrategy movementStrategy, Position position) {
        this.name = name;
        this.movementStrategy = movementStrategy;
        this.position = position;
    }

    public void move() {
        if (movementStrategy.isMovable()) {
            position = position.move();
        }
    }

    public CarStatus getStatus() {
        return new CarStatus(name.name(), position.position());
    }

    public String getName() {
        return name.name();
    }

    @Override
    public int compareTo(Car other) {
        return position.compareTo(other.position);
    }
}
