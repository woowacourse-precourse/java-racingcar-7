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
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final Car targetObject = (Car) object;
        return criticalPoint == targetObject.criticalPoint && Objects.equals(carName, targetObject.carName);
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
