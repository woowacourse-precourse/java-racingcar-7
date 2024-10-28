package racingcar.controller;

import racingcar.model.CarsManager;
import racingcar.view.OutputView;
import racingcar.dto.RacingResult;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private final OutputView outputView;
    private final InputController inputController;

    public GameController(InputController inputController, OutputView outputView) {
        this.inputController = inputController;
        this.outputView = outputView;
    }

    public void run() {
        CarsManager cars = CarsManager.by(inputController.readCarNames());
        moveCars(cars);
        printWinners(cars);
    }

    private void moveCars(CarsManager cars) {
        int numberOfTrials = inputController.readTrialsCount();
        outputView.printResult();
        for (int trial = 0; trial < numberOfTrials; trial++) {
            moveCarsOnce(cars);
        }
    }

    private void moveCarsOnce(CarsManager cars) {
        cars.move();
        List<RacingResult> racingResults = convertToRacingResults(cars);
        outputView.printRacing(racingResults);
    }

    private List<RacingResult> convertToRacingResults(CarsManager cars) {
        return cars.getCars().stream()
                .map(car -> new RacingResult(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    private void printWinners(CarsManager cars) {
        outputView.printWinners(cars.getWinners());
    }
}