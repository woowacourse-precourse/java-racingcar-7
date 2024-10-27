package racingcar.game;

import racingcar.integer_generator.IntegerGenerator;
import racingcar.car.Car;
import racingcar.car.CarManager;
import racingcar.view.input.InputValue;

import java.util.List;


public class RacingCarGame {

    private static final int MIN_VALUE_TO_MOVE = 4;

    private final int attemptCount;
    private final CarManager carManager = new CarManager();
    private final CarPositionLogRepository carPositionLogRepository = new CarPositionLogRepository();
    private final IntegerGenerator integerGenerator;

    public RacingCarGame(InputValue inputValue, IntegerGenerator integerGenerator) {
        List<String> carNames = inputValue.getCarNames();
        int attemptCount = inputValue.getAttemptCount();

        carManager.createCars(carNames);
        carPositionLogRepository.saveCarNames(carNames);

        this.attemptCount = attemptCount;
        this.integerGenerator = integerGenerator;
    }

    public GameResult getGameResult() {
        return new GameResult(attemptCount, carPositionLogRepository.getCarPositionLog());
    }

    public void play() {
        moveCars();
    }

    private void moveCars() {
        for (int i = 0; i < attemptCount; i++) {
            List<Car> cars = carManager.getCars();
            moveCar(cars);
        }
    }

    private void moveCar(List<Car> cars) {
        cars.forEach(car -> {
            int randomNumber = integerGenerator.generate();
            if (randomNumber >= MIN_VALUE_TO_MOVE) {
                car.move();
            }
            carPositionLogRepository.saveCarPositionLog(car);
        });
    }
}
