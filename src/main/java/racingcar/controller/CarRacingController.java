package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarRacingGame;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumberGenerator;
import racingcar.dto.CarDto;
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
        Cars cars = initCars();
        int rounds = inputView.readGameRounds();
        return new CarRacingGame(cars, new RandomNumberGenerator(), rounds);
    }

    private Cars initCars() {
        List<String> carNames = inputView.readCarNames();
        return Cars.from(carNames);
    }

    private void gameStart(final CarRacingGame carRacingGame) {
        outputView.printResult();
        while (carRacingGame.canPlay()) {
            List<Car> cars = carRacingGame.start();
            outputView.printCurrentPosition(convertCarToDto(cars));
        }
    }

    private List<CarDto> convertCarToDto(List<Car> cars) {
        return cars.stream().map(CarDto::from).toList();
    }

    private void showWinners(CarRacingGame carRacingGame) {
        List<String> winners = carRacingGame.getWinners();
        outputView.printWinners(winners);
    }

}
