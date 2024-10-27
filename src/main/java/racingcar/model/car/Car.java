package racingcar.model.car;

import racingcar.model.movement.Movement;

public class Car {
    private final CarName carName;
    private final MoveResults moveResults;
    private final Movement movement;

    public Car(CarName carName, MoveResults moveResults, Movement movement) {
        this.carName = carName;
        this.moveResults = moveResults;
        this.movement = movement;
    }

    public static Car of(String carName, Movement movement) {
        return new Car(CarName.of(carName), new MoveResults(), movement);
    }

    public void move() {
        moveResults.add(movement.isMove());
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
