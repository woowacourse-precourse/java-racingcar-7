package racingcar.entity;

public class Car {
    private String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
