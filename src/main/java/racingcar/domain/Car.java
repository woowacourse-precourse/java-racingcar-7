package racingcar.domain;

public class Car {

    private final static Integer START = 0;
    public final String carName;
    public Integer carPosition;

    public Car(String carName) {
        this.carName = carName;
        this.carPosition = START;
    }

    public void move() {
        carPosition++;
    }

    public String getCarName() {
        return carName;
    }

    public Integer getCarPosition() {
        return carPosition;
    }


}
