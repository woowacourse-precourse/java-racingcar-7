package racingcar.model;

public class RacingGame {
    private final CarRepository carRepository;
    private final MovingCar movingCar;

    public RacingGame(String[] carNames) {
        carRepository = new CarRepository(carNames);
        movingCar = new MovingCar();
    }

    public void moveCar() {
        movingCar.moveCars(carRepository.getCars());
    }

    public Car[] getCars() {
        return carRepository.getCars();
    }
}
