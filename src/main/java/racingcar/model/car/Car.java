package racingcar.model.car;

import racingcar.model.movementstrategy.MovementStrategy;

public class Car {
    private final CarName carName;
    private final MoveResults moveResults;
    private final MovementStrategy movementStrategy;

    public Car(CarName carName, MoveResults moveResults, MovementStrategy movementStrategy) {
        this.carName = carName;
        this.moveResults = moveResults;
        this.movementStrategy = movementStrategy;
    }

    public static Car of(String carName, MovementStrategy movementStrategy) {
        return new Car(CarName.of(carName), new MoveResults(), movementStrategy);
    }

    public void move() {
        moveResults.add(movementStrategy.isMove());
    }

    public int getPosition() {
        return moveResults.getPosition();
    }

    public int getPositionAtSpecificCount(int count) {
        return moveResults.getPositionAtSpecificCount(count);
    }

    public String getName() {
        return carName.getName();
    }

    private CarName getCarName() {
        return carName;
    }

    @Override
    public int hashCode() {
        return this.carName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Car car = (Car) obj;
        return carName.equals(car.getCarName());
    }
}
