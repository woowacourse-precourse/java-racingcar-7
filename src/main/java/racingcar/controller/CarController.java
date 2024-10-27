package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.service.CarMoveManager;
import racingcar.service.InputSplitter;
import racingcar.service.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
    private final CarMoveManager carMoveManager;
    private final InputSplitter inputSplitter;
    private final RandomNumberGenerator randomNumberGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public CarController(CarMoveManager carMoveManager, InputSplitter inputSplitter,
                         RandomNumberGenerator randomNumberGenerator) {
        this.carMoveManager = carMoveManager;
        this.inputSplitter = inputSplitter;
        this.randomNumberGenerator = randomNumberGenerator;
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
    }

    public void play() {
        String carNamesInput = inputView.getCarNames();

        int count = Integer.parseInt(inputView.getCount());

        Cars cars = new Cars();

        String[] carNames = inputSplitter.getCarNmaes(carNamesInput);
        for (String carName : carNames) {
            cars.addCar(new Car(carName.trim()));
        }

        for (int i = 0; i < count; i++) {
            for (Car car : cars.getCars()) {
                int number = randomNumberGenerator.gernerateRandomNumber();
                car.move(carMoveManager.canMove(number));
            }
            outputView.showRoundResult(cars);
        }

        List<Car> winners = cars.getWinners();
        outputView.showWinners(winners);
    }
}
