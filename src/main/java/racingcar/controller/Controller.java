package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;

public class Controller {
    private final InputController inputController;
    private final OutputController outputController;
    private final CarController carController;
    private final RaceController raceController;

    public Controller(InputController inputController, OutputController outputController, CarController carController,
                      RaceController raceController) {
        this.inputController = inputController;
        this.outputController = outputController;
        this.carController = carController;
        this.raceController = raceController;
    }

    public void startGame() {
        String inputCarNames = inputController.inputCarNames();
        int inputAttemptCount = inputController.inputAttemptCount();

        List<String> carNames = carController.getCarNames(inputCarNames);
        List<Car> carList = carController.registerCar(carNames);

        Race race = raceController.registerRace(carList, inputAttemptCount);
        raceController.playRound(race);

        List<Car> winnerCarList = raceController.getWinnerCarList(race);
        outputController.printWinners(winnerCarList);
    }
}
