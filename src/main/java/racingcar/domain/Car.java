package racingcar.domain;

public class Car {
    private final String carName;
    private int location;

    public Car(String carName) {
        this.carName = carName;
        this.location = 0;
    }

    public String getCarName () {
        return carName;
    }

    public int getLocation () {
        return location;
    }

    public void increaseLocation () {
        this.location++;
    }
}
