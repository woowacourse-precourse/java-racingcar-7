package racingcar.domain;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private static final int MOVE_POINT = 4;

    private final CarName carName;
    private int position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = INITIAL_POSITION;
    }

    public void moveCar(int randomNumber) {
        if (randomNumber >= MOVE_POINT) {
            position++;
        }
    }

    public CarName getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
