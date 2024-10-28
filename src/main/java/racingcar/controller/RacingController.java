package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startRace() {
        List<String> carNames = inputView.getInputCars();
        List<Car> cars = initializeCars(carNames);

        int rounds = inputView.getInputCount();
        Racing racing = new Racing(cars, rounds);
        racing.startRace();

        List<Car> winners = racing.getWinners();
        outputView.printWinners(winners);
    }

    private List<Car> initializeCars(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }
}
