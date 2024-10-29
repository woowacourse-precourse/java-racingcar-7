package racingcar.model;

public class RacingCar {
    private final String carName;
    private int location;

    public RacingCar(String carName) {
        this.carName = carName;
        location = 0;
    }

    public void move() {
        location += 1;
    }

    public String getCarName() {
        return carName;
    }

    public int getLocation() {
        return location;
    }
}
