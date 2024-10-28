package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.Race;

public class Controller {
    private final InputController inputController;
    private final OutputController outputController;
    private final CarController carController;
    private final RaceController raceController;

    public Controller(final InputController inputController, final OutputController outputController,
                      final CarController carController,
                      final RaceController raceController) {
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

        printGame(race);

        List<Car> winnerCarList = raceController.getWinnerCarList(race);
        outputController.printWinners(winnerCarList);
    }

    private void printGame(final Race race) {
        outputController.printEndLine();
        outputController.printGameResultMessage();

        IntStream.range(0, race.getAttemptCount()).forEach(attemptCount -> {
            raceController.playRound(race);
            outputController.printRoundResult(race);
            outputController.printEndLine();
        });
    }
}
