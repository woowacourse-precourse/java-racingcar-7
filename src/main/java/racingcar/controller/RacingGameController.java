package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    private final RacingGameService racingGameService = new RacingGameService();

    public void start() {
        List<Car> cars = getCarsFromInput();
        int moveCount = getMoveCountFromInput();

        raceAllRounds(cars, moveCount);

        printFinalWinners(cars);
    }

    private List<Car> getCarsFromInput() {
        String carNamesInput = InputView.getCarNames();
        return racingGameService.createCars(carNamesInput);
    }

    private int getMoveCountFromInput() {
        String moveCountInput = InputView.getMoveCount();
        return racingGameService.parseMoveCount(moveCountInput);
    }

    private void raceAllRounds(List<Car> cars, int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            racingGameService.raceOneRound(cars);
            OutputView.printRoundResult(cars);
        }
    }

    private void printFinalWinners(List<Car> cars) {
        List<Car> winners = racingGameService.findWinners(cars);
        OutputView.printWinners(winners);
    }
}
