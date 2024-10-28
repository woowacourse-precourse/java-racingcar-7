package racingcar.controller;

import racingcar.model.CarsManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.dto.RacingResult;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private final OutputView outputView;
    private final InputView inputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        CarsManager cars = CarsManager.by(inputView.readCarNames());
        moveCars(cars);
        printWinners(cars);
    }

    private void moveCars(CarsManager cars) {
        int numberOfTrials = inputView.readTrialsCount();
        outputView.printResult();
        for (int trial = 0; trial < numberOfTrials; trial++) {
            moveCarsOnce(cars);
        }
    }

    private void moveCarsOnce(CarsManager cars) {
        cars.move();
        List<RacingResult> racingResults = cars.getCars().stream()
                .map(car -> new RacingResult(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
        outputView.printRacing(racingResults);
    }

    private void printWinners(CarsManager cars) {
        outputView.printWinners(cars.getWinners());
    }
}