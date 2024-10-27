package racingcar.controller;

import racingcar.dto.CarRaceSnapshotDTOs;
import racingcar.model.CarRace;
import racingcar.model.Cars;
import racingcar.util.RandomMovementStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RandomMovementStrategy randomMovementStrategy;

    public CarRaceController(InputView inputView, OutputView outputView, RandomMovementStrategy randomMovementStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomMovementStrategy = randomMovementStrategy;
    }

    public void raceStart() {
        Cars cars = new Cars(inputView.readCars(), randomMovementStrategy);
        int attemptCount = inputView.readAttemptCount();

        CarRace carRace = new CarRace(attemptCount);
        carRace.startRace(cars);

        CarRaceSnapshotDTOs carRaceSnapshotDTOs = CarRaceSnapshotDTOs.from(carRace.getCarRaceSnapshots());
        outputView.printResult(carRaceSnapshotDTOs);

        outputView.printWinners(carRace.getFinalWinners());
    }
}
