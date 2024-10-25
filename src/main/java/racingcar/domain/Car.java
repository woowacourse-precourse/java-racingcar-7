package racingcar.domain;

public class Car {

    private final int INITIAL_POSITION = 0;

    private final CarName carName;
    private final int position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = INITIAL_POSITION;
    }
}
