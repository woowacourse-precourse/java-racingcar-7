package racingcar.domain;

class Car {

    private final CarName carName;
    private final int criticalPoint;

    Car(final CarName carName, final int criticalPoint) {
        this.carName = carName;
        this.criticalPoint = criticalPoint;
    }
}
