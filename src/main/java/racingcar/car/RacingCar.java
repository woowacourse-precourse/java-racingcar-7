package racingcar.car;

public class RacingCar extends Car {
    public RacingCar(String name, int position) {
        super(name, position);
    }

    @Override
    public void move() {
        incrementPosition(1);
    }
}
