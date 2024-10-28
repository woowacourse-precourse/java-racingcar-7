package racingcar.model;

public class RacingGame {
    private final Car[] cars;
    private final CarRepository carRepository;
    private final MovingCar movingCar;
    private final GetWinner getWinner;

    public RacingGame(String[] carNames) {
        carRepository = new CarRepository(carNames);
        movingCar = new MovingCar();
        getWinner = new GetWinner();
        cars = carRepository.getCars();
    }

    public void moveCar() {
        movingCar.moveCars(carRepository.getCars());
    }

    public Car[] getCars() {
        return carRepository.getCars();
    }

    public String getWinners() {
        return getWinner.findWinner(cars);
    }
}
