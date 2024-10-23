package racingcar.domain;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
    }

    public void move() {
        position ++;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }
}
