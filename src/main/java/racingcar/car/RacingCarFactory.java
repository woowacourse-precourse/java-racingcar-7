package racingcar.car;

public class RacingCarFactory extends CarFactory {
    @Override
    public Car createCar() {
        return new RacingCar();
    }
}
