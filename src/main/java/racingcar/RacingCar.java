package racingcar;

public class RacingCar {

    private String carName;
    private int position;

    public void move() {
        this.position ++;
    }

    public RacingCar(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
