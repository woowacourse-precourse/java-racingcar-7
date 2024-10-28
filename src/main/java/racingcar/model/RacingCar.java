package racingcar.model;

public class RacingCar {
    private int position;
    private final String carName;

    public RacingCar(String carName) {
        this.position = 0;
        this.carName = carName;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }
}
