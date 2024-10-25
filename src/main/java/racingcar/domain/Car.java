package racingcar.domain;

public class Car {

    private static final int INITIAL_POSITION = 0;

    private final CarName carName;
    private int position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = INITIAL_POSITION;
    }
}
