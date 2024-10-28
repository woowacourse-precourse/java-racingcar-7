package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.CarRaceSnapshotDTOs;
import racingcar.model.CarRace;
import racingcar.model.Cars;
import racingcar.util.MovementStrategy;
import racingcar.util.RandomMovementStrategy;
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
        Cars cars = new Cars(inputView.readCars(), movementStrategy);
        int attemptCount = inputView.readAttemptCount();

        CarRace carRace = new CarRace(attemptCount);
        carRace.startRace(cars);

        CarRaceSnapshotDTOs carRaceSnapshotDTOs = CarRaceSnapshotDTOs.from(carRace.getCarRaceSnapshots());
        outputView.printResult(carRaceSnapshotDTOs);

        outputView.printWinners(carRace.getFinalWinners());

        Console.close();
    }
}
