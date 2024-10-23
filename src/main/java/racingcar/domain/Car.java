package racingcar.domain;

public class Car {

    private final static Integer START = 0;
    public final String carName;
    public final Integer carPosition;

    public Car(String carName) {
        this.carName = carName;
        this.carPosition = START;
    }

}
