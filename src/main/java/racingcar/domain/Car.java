package racingcar.domain;

import java.util.Objects;

class Car {

    private final CarName carName;
    private final int criticalPoint;

    Car(final CarName carName, final int criticalPoint) {
        this.carName = carName;
        this.criticalPoint = criticalPoint;
    }

    CarName getCarName() {
        return this.carName;
    }

    boolean canMove(final MoveCondition moveCondition) {
        return moveCondition.getConditionPoint() >= criticalPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return criticalPoint == car.criticalPoint && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, criticalPoint);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName=" + carName +
                ", criticalPoint=" + criticalPoint +
                '}';
    }
}
