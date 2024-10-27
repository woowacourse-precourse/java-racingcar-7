package racingcar.Cars;

public class RacingCar extends Car {
    public RacingCar() {
        super();
    }

    @Override
    protected void moveCar() {
        super.moveDistance++;
    }
}
