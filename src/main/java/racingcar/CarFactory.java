package racingcar;

public abstract class CarFactory {

    public static RacingCar createRacingCars(String carName) {
        return new RacingCar(carName);
    }
}
