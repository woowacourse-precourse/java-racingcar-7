package racingcar.model;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
