package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarRacingGame;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public CarRacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        CarRacingGame carRacingGame = gameInit();
        gameStart(carRacingGame);
        showWinners(carRacingGame);
    }

    private CarRacingGame gameInit() {
        List<Car> carList = initCars();
        int rounds = inputView.readGameRounds();
        return new CarRacingGame(Cars.from(carList), new RandomNumberGenerator(), rounds);
    }

    private List<Car> initCars() {
        List<String> carNames = inputView.readCarNames();
        return carNames.stream().map(Car::new).toList();
    }

    private void gameStart(final CarRacingGame carRacingGame) {
        outputView.printResult();
        while (carRacingGame.canPlay()) {
            List<Car> cars = carRacingGame.start();
            outputView.printCurrentPosition(cars);
        }
    }

    private void showWinners(CarRacingGame carRacingGame) {
        List<String> winners = carRacingGame.getWinners();
        outputView.printWinners(winners);
    }

}
