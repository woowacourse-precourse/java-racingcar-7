package racingcar.car;

public class RacingCar extends Car {
    public RacingCar() {
        super();
    }

    @Override
    public void moveCar() {
        super.moveDistance++;
    }
}
