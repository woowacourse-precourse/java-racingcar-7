package racingcar;

public class RacingCar {

    private static final int MOVE_THRESHOLD = 4;

    private final CarName carName;
    private int location;

    public RacingCar(CarName carName, int location) {
        this.carName = carName;
        this.location = location;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }
}
