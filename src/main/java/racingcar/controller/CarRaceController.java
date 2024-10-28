package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.CarRaceSnapshotDTOs;
import racingcar.model.CarRace;
import racingcar.model.Cars;
import racingcar.util.MovementStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MovementStrategy movementStrategy;

    public CarRaceController(InputView inputView, OutputView outputView, MovementStrategy movementStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.movementStrategy = movementStrategy;
    }

    public void raceStart() {
        Cars cars = initializeCars();
        CarRace carRace = initializeCarRace(cars);

        displayResults(carRace);
        displayWinners(carRace);

        Console.close();
    }

    private Cars initializeCars() {
        return new Cars(inputView.readCars(), movementStrategy);
    }

    private CarRace initializeCarRace(Cars cars) {
        int attemptCount = inputView.readAttemptCount();

        CarRace carRace = new CarRace(attemptCount);
        carRace.startRace(cars);

        return carRace;
    }

    private void displayResults(CarRace carRace) {
        CarRaceSnapshotDTOs carRaceSnapshotDTOs = CarRaceSnapshotDTOs.from(carRace.getCarRaceSnapshots());

        outputView.printResult(carRaceSnapshotDTOs);
    }

    private void displayWinners(CarRace carRace) {
        outputView.printWinners(carRace.getFinalWinners());
    }
}
