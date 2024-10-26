package racingcar.domain;

public class Car {
    private final CarName carName;
    private final int position;

    public Car(CarName carName) {
        this.carName = carName;
        position = 0;
    }
}
